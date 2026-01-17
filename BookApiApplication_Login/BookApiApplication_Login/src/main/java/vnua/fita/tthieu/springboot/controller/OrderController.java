package vnua.fita.tthieu.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vnua.fita.tthieu.springboot.dto.CreateOrderRequestDTO;
import vnua.fita.tthieu.springboot.dto.OrderDetailDTO;
import vnua.fita.tthieu.springboot.entity.Order;
import vnua.fita.tthieu.springboot.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> getDetail(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderDetail(id));
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOrderRequestDTO req) {
        Order saved = orderService.createOrder(req);
        return ResponseEntity.ok(Map.of(
            "order_id", saved.getOrder_id(),
            "order_ro", saved.getOrder_ro()
        ));
    }
}
