package vnua.fita.tthieu.springboot;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import vnua.fita.tthieu.springboot.entity.Role;
import vnua.fita.tthieu.springboot.entity.User;
import vnua.fita.tthieu.springboot.repository.RoleRepository;
import vnua.fita.tthieu.springboot.repository.UserRepository;

// Về bản chất @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
// @Configuration: là bean cấu hình
// @EnableAutoConfiguration → bật cơ chế auto config như JpaRepositoriesAutoConfiguration
// @ComponentScan → quét package hiện tại (nơi đặt class @SpringBootApplication) và các package con

// Nguyên tắc trong SpringBoot: Tạo các đối tượng lưu trong ApplicationContext gọi là bean để tái sử dụng
// tối ưu hiệu quả. Các bean này có thể được tạo qua các cơ chế:
// + chủ động dùng annotation (@Component, @Service, @Repository, @Controller, hoặc @Configuration)
// + các phương thức có @Bean trong class @Configuration
// + cấu hình tự động của SpringBoot (Spring Boot tự tạo bean (ví dụ DataSource, EntityManagerFactory, UserRepository, ...)
// + đăng ký thủ công (context.registerBean(...) hoặc @Import)
// "CHỈ KHI TỒN TẠI BEAN TRONG APPLICATIONCONTEXT THÌ MỚI CÓ THỂ 
// DÙNG BEAN ĐÓ ĐỂ INJECT VÀO SỬ DỤNG Ở MỘT CLASS NÀO ĐÓ" (inject với @Autowired)

@SpringBootApplication
public class BookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}
	
	// Các phương thức tự động chạy để khởi tạo phần dữ liệu chắc chắn phải có
	// gồm các loại quyền của user và khởi tạo account cho super admin
	
	@Bean
    public CommandLineRunner initUserRole(RoleRepository roleRepo) {
        return args -> {
            if (roleRepo.findByName("ROLE_USER").isEmpty()) {
                Role r1 = new Role();
                r1.setName("ROLE_USER");
                roleRepo.save(r1);
            }
            if (roleRepo.findByName("ROLE_ADMIN").isEmpty()) {
                Role r2 = new Role();
                r2.setName("ROLE_ADMIN");
                roleRepo.save(r2);
            }
        };
    }
	
	// @Bean CommandLineRunner đặt trong lớp có @@SpringBootApplication hoặc @Configuration sẽ được tự động chạy
	// khi ứng dụng khởi động, các tham số cũng sẽ được tự động tạo đối tượng để truyền vào
	@Bean
	public CommandLineRunner initAdmin(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
	    return args -> {
	        if (userRepo.findByUsername("admin").isEmpty()) {
	            User admin = new User();
	            admin.setUsername("admin");
	            admin.setPassword(encoder.encode("admin123")); // mã hóa mật khẩu trước khi ghi vào CSDL
	            Role adminRole = roleRepo.findByName("ROLE_ADMIN") // Trả lại Optional<Role>
	                            .orElseThrow(() -> new RuntimeException("Role admin không tồn tại"));
	            				// orElseThrow trả lại Role trong Optional, nếu ko có thì trả về exception
	            
	            // thuộc tính roles trong User có kiểu Set nên cần lệnh Set.of(..) để chuyển kiểu
	            admin.setRoles(Set.of(adminRole)); 
	            userRepo.save(admin);
	        }
	    };
	}

}
