package vnua.fita.tthieu.springboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vnua.fita.tthieu.springboot.dto.CreateOrderItemDTO;
import vnua.fita.tthieu.springboot.dto.CreateOrderRequestDTO;
import vnua.fita.tthieu.springboot.dto.OrderDetailDTO;
import vnua.fita.tthieu.springboot.dto.OrderItemDTO;
import vnua.fita.tthieu.springboot.entity.Book;
import vnua.fita.tthieu.springboot.entity.Order;
import vnua.fita.tthieu.springboot.entity.OrderBook;
import vnua.fita.tthieu.springboot.repository.BookRepository;
import vnua.fita.tthieu.springboot.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    public OrderDetailDTO getOrderDetail(Long id) {
        Order order = (Order) orderRepository.findDetailById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderDetailDTO dto = new OrderDetailDTO();
        dto.orderId = order.getOrder_id();
        dto.orderNo = order.getOrder_ro();
        dto.customerUsername = order.getCustomer_username();
        dto.deliveryAddress = order.getDelivery_address();
        dto.paymentMode = order.getPayment_mode();
        dto.paymentStatus = order.getPayment_status();

        List<OrderItemDTO> items = new ArrayList<>();
        int total = 0;

        for (OrderBook ob : order.getOrderBook()) {
            OrderItemDTO it = new OrderItemDTO();

            it.bookId = ob.getBook().getBook_id();     
            it.title  = ob.getBook().getTitle();

            it.price = ob.getPrice();
            it.quantity = ob.getQuantity();
            it.lineTotal = it.price * it.quantity;

            total += it.lineTotal;
            items.add(it);
        }

        dto.items = items;
        dto.totalCost = total;
        return dto;
    }
    
    @Transactional
    public Order createOrder(CreateOrderRequestDTO req) {
    	 

        Order order = new Order();
        order.setCustomer_username(req.customer_username);
        order.setPayment_mode(req.payment_mode);
        order.setDelivery_address(req.delivery_address);

        order.setOrder_date(LocalDateTime.now());
        order.setStatus_date(LocalDateTime.now());
        order.setOrder_Status(0);
        order.setPayment_status(false);

        Order saved = orderRepository.save(order);

        int total = 0;
        List<OrderBook> obs = new ArrayList<>();

        for (CreateOrderItemDTO item : req.items) {
            Book book = bookRepository.findById(item.book_id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + item.book_id));

            OrderBook ob = new OrderBook();
            ob.setOrder(saved);
            ob.setBook(book);
            ob.setQuantity(item.quantity);
            ob.setPrice(book.getPrice());

            total += ob.getPrice() * ob.getQuantity();
            obs.add(ob);
        }

        saved.setOrderBook(obs);
        saved.setTotal_cost(total);
        saved.setOrder_ro("OD" + String.format("%06d", saved.getOrder_id()));

        return orderRepository.save(saved);
    }

}
