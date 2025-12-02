package com.vgdloorder.service;

import com.vgdloorder.model.MenuItem;
import com.vgdloorder.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(MenuItem item){ return menuItemRepository.save(item); }
    public List<MenuItem> getMenuItemsByVendor(Long vendorId){ return menuItemRepository.findByVendorId(vendorId); }
    public List<MenuItem> getMenuItemsByVendorAndTime(Long vendorId, String timeCategory){ return menuItemRepository.findByVendorIdAndTimeCategory(vendorId,timeCategory); }
    public void deleteMenuItem(Long id){ menuItemRepository.deleteById(id); }
}
