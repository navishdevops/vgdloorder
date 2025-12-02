package com.vgdloorder.controller;

import com.vgdloorder.dto.AdminLoginDTO;
import com.vgdloorder.model.Admin;
import com.vgdloorder.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Admin login(@RequestBody AdminLoginDTO dto){
        return adminService.authenticate(dto.getUsername(), dto.getPassword());
    }

    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }
}
