package com.vgdloorder.service;

import com.vgdloorder.model.Order;
import com.vgdloorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        order.setOrderTime(LocalDateTime.now());
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByVendor(Long vendorId){ return orderRepository.findByVendorId(vendorId); }

    public Order updateOrderStatus(Long orderId, String status){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
