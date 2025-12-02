package com.vgdloorder.repository;

import com.vgdloorder.model.DeliveryBoy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeliveryBoyRepository extends JpaRepository<DeliveryBoy, Long> {
    List<DeliveryBoy> findByAvailableTrue();
}
