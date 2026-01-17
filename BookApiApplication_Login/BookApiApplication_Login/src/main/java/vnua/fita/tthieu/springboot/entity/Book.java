package vnua.fita.tthieu.springboot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tblbook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    // Tiêu đề Sách
    @Column(nullable = false)
    private String title;
    
    // Tác giả
    @Column(nullable = false)
    private String author;
    
    // Giá
    private int price;

    // Số cuốn sách còn trong kho
    private int quantity_in_stock;
    
    // chi tiết cuốn sách
    @Column(columnDefinition = "TEXT")
    private String detail;
    
    //Đường dẫn ảnh
    private String image_path;
    
   //Ngày nhập sách
    private LocalDateTime  create_date;
    
 // Người tạo
    private String createdBy;

    // Người sửa gần nhất
    private String updatedBy;
   
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	// Constructors ko tham số
    public Book() {}
    
    // Constructor có tham số chỉ cần nếu Dev cần dùng riêng, JPA ko cần
    // Tuy nhiên JPA cần constructor ko tham số để gọi tạo đối tượng
    // Nếu đã định nghĩa constructor có tham số thì Java ko cấp constructor ko tham 
    // số mặc định nữa do đó phải định nghĩa constructor không tham số đi kèm (như ở trên), 
    // nếu ko JPA sẽ ko hoạt động tạo đối tượng đc
    // Nếu Dev ko cần dùng riêng, ko cần định nghĩa constructor nào hết, dùng mặc định của Java
    public Book(String title, String author, int price,int quantity_in_stock, String detail, String image_path, LocalDateTime  create_date) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity_in_stock = quantity_in_stock;
        this.detail = detail;
        this.image_path = image_path;
        this.create_date = create_date;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public LocalDateTime  getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime  create_date) {
		this.create_date = create_date;
	}

	public Long getBook_id() {
		return book_id;
	}
    
	@PrePersist
	public void prePersist() {
	    if (this.create_date == null) {
	        this.create_date = LocalDateTime.now();
	    }
	}

  
}

