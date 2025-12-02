package com.vgdloorder.service;

import com.vgdloorder.model.Admin;
import com.vgdloorder.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin authenticate(String username, String password){
        Optional<Admin> adminOpt = adminRepository.findByUsername(username);
        if(adminOpt.isPresent() && adminOpt.get().getPassword().equals(password)){
            return adminOpt.get();
        }
        throw new RuntimeException("Invalid username or password");
    }

    public Admin createAdmin(Admin admin){ return adminRepository.save(admin); }
}
