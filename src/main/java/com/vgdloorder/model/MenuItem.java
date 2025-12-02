package com.vgdloorder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String timeCategory;

    @ManyToOne
    @JoinColumn(name="vendor_id")
    private Vendor vendor;
}
