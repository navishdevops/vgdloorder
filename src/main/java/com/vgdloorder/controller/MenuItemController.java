package com.vgdloorder.controller;

import com.vgdloorder.model.MenuItem;
import com.vgdloorder.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/vendor/{vendorId}")
    public List<MenuItem> getMenuItemsByVendor(@PathVariable Long vendorId){
        return menuItemService.getMenuItemsByVendor(vendorId);
    }

    @GetMapping("/vendor/{vendorId}/time/{timeCategory}")
    public List<MenuItem> getMenuItemsByVendorAndTime(@PathVariable Long vendorId, @PathVariable String timeCategory){
        return menuItemService.getMenuItemsByVendorAndTime(vendorId, timeCategory);
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem item){
        return menuItemService.createMenuItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id){
        menuItemService.deleteMenuItem(id);
    }
}
