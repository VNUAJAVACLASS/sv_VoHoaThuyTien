package vnua.fita.tthieu.springboot.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name =	"tblorder")
public class Order {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long order_id;
	
	// Mã hóa đơn cho khách hàng
    @Column(length = 10)
    private String order_ro;

    // Username khách hàng
    @Column(length = 30)
    private String customer_username;

    // Ngày đặt hàng
    private LocalDateTime order_date;

    // Ngày duyệt đơn
    private LocalDateTime order_approve_date;

    // cash / transfer
    @Column(length = 30)
    private String payment_mode;

    // Trạng thái đơn hàng
    // 0: chờ xác nhận, 1: đang giao, 2: đã giao, 3: hủy, 4: trả hàng, 5: hết hàng
    private int order_Status;

    // Tổng tiền
    private int total_cost;

    // Ảnh chuyển khoản
    @Column(length = 200)
    private String payment_img;

    // Trạng thái thanh toán (0: chưa, 1: đã)
    private Boolean payment_status;

    // Ngày thay đổi trạng thái
    private LocalDateTime status_date;

    // Địa chỉ giao hàng
    @Column(length = 200)
    private String delivery_address;

    // Constructor bắt buộc
    public Order() {}

    // 1 đơn hàng có nhiều dòng sách
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderBook> orderBook = new ArrayList<>();

	public String getOrder_ro() {
		return order_ro;
	}


	public void setOrder_ro(String order_ro) {
		this.order_ro = order_ro;
	}


	public String getCustomer_username() {
		return customer_username;
	}


	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}


	public LocalDateTime getOrder_date() {
		return order_date;
	}


	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}


	public LocalDateTime getOrder_approve_date() {
		return order_approve_date;
	}


	public void setOrder_approve_date(LocalDateTime order_approve_date) {
		this.order_approve_date = order_approve_date;
	}


	public String getPayment_mode() {
		return payment_mode;
	}


	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}


	public int getOrder_Status() {
		return order_Status;
	}


	public void setOrder_Status(int order_Status) {
		this.order_Status = order_Status;
	}


	public int getTotal_cost() {
		return total_cost;
	}


	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}


	public String getPayment_img() {
		return payment_img;
	}


	public void setPayment_img(String payment_img) {
		this.payment_img = payment_img;
	}


	public Boolean getPayment_status() {
		return payment_status;
	}


	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}


	public LocalDateTime getStatus_date() {
		return status_date;
	}


	public void setStatus_date(LocalDateTime status_date) {
		this.status_date = status_date;
	}


	public String getDelivery_address() {
		return delivery_address;
	}


	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public List<OrderBook> getOrderBook() {
		return orderBook;
	}


	public void setOrderBook(List<OrderBook> orderBook) {
		this.orderBook = orderBook;
	}


	public Long getOrder_id() {
		return order_id;
	}



    // Getter & Setter
    
}
