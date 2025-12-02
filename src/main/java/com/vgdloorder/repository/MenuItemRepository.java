package com.vgdloorder.repository;

import com.vgdloorder.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByVendorId(Long vendorId);
    List<MenuItem> findByVendorIdAndTimeCategory(Long vendorId, String timeCategory);
}
