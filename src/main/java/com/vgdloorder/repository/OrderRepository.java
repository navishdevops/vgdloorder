package com.vgdloorder.repository;

import com.vgdloorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByVendorId(Long vendorId);
}
