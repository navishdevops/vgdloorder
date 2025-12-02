package com.vgdloorder.controller;

import com.vgdloorder.dto.OrderDTO;
import com.vgdloorder.model.Order;
import com.vgdloorder.service.MenuItemService;
import com.vgdloorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public Order createOrder(@RequestBody OrderDTO dto){
        Order order = new Order();
        order.setCustomerName(dto.getCustomerName());
        order.setCustomerPhone(dto.getCustomerPhone());
        order.setCustomerAddress(dto.getCustomerAddress());
        order.setNotes(dto.getNotes());
        order.setVendorId(dto.getVendorId());
        return orderService.createOrder(order);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<Order> getOrdersByVendor(@PathVariable Long vendorId){
        return orderService.getOrdersByVendor(vendorId);
    }

    @PutMapping("/{orderId}/status")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam String status){
        return orderService.updateOrderStatus(orderId, status);
    }
}
