package com.vgdloorder.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String notes;
    private List<Long> menuItemIds;
    private Long vendorId;
}
