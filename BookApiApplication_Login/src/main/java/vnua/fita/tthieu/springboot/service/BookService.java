package vnua.fita.tthieu.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnua.fita.tthieu.springboot.entity.Book;
import vnua.fita.tthieu.springboot.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Lấy danh sách sách (public)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Lấy theo ID (nếu cần)
    // Trong SpringBoot có cơ chế xử lý ngoại lệ toàn cục, cá exception đẩy ra ở RestController
    // sẽ được bắt xử lý chuyển đổi thành Http response trả lại Client mà không đẩy ra JVM như 
    // chương trình Java thuần làm ngắt chương trình.
    public Book findById(Long book_id) {
        return bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("Sách không tồn tại"));
    }

    // Tạo mới Sách
    public Book save(Book book) {	
        return bookRepository.save(book);
    }

    // Cập nhật (chỉ admin)
    public Book update(Long book_id, Book updatedBook, String updatedBy) {
        Book existing = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("Sách không tồn tại"));

        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor()); 
        existing.setPrice(updatedBook.getPrice());
        existing.setQuantity_in_stock(updatedBook.getQuantity_in_stock());
        existing.setDetail(updatedBook.getDetail());
        existing.setImage_path(updatedBook.getImage_path());
        existing.setCreate_date(updatedBook.getCreate_date());
        existing.setUpdatedBy(updatedBy); // account admin nào thực hiện update

        return bookRepository.save(existing);
    }

    // Xóa (chỉ admin)
    public void delete(Long book_id) {
        if (!bookRepository.existsById(book_id)) {
            throw new RuntimeException("Sách không tồn tại");
        }
        bookRepository.deleteById(book_id);
    }
}
