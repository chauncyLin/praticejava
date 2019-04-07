package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private String id;
    private Student student;
    private OrderStatus status;
    private LocalDateTime placedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String orderId) {
        this.id = orderId;
    }

}
