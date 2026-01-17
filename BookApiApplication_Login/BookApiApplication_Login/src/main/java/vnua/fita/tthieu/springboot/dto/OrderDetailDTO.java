package vnua.fita.tthieu.springboot.dto;

import java.util.List;

public class OrderDetailDTO {
    public Long orderId;
    public String orderNo;
    public String customerUsername;
    public String deliveryAddress;
    public String paymentMode;
    public Boolean paymentStatus;
    public int totalCost;
    public List<OrderItemDTO> items;
}
