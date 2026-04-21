package com.carbon.rtrb.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "remaining_qty")
    private Integer remainingQty;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "credit_id")
    private String creditId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (remainingQty == null) remainingQty = quantity;
        if (status == null) status = OrderStatus.OPEN;
    }
}