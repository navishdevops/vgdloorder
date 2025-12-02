package com.vgdloorder.service;

import com.vgdloorder.model.Vendor;
import com.vgdloorder.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor){ return vendorRepository.save(vendor); }
    public List<Vendor> getVendors(){ return vendorRepository.findAll(); }
    public Vendor updateVendor(Long id, Vendor vendor){
        Vendor existing = vendorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendor not found"));
        existing.setName(vendor.getName());
        existing.setAddress(vendor.getAddress());
        existing.setContactNumber(vendor.getContactNumber());
        return vendorRepository.save(existing);
    }
    public void deleteVendor(Long id){ vendorRepository.deleteById(id); }
}
