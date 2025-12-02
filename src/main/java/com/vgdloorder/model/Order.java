package com.vgdloorder.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String notes;
    private LocalDateTime orderTime;
    private Long vendorId;
    private String status;
}
