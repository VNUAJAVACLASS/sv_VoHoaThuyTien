package vnua.fita.tthieu.springboot.dto;

import java.util.List;

public class CreateOrderRequestDTO {
    public String customer_username;
    public String payment_mode;
    public String delivery_address;
    public List<CreateOrderItemDTO> items;
}