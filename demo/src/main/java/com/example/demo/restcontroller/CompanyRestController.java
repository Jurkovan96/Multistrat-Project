package com.example.demo.restcontroller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Company;
import com.example.demo.model.AddressDto;
import com.example.demo.service.AddressService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@SessionAttributes
public class CompanyRestController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressService.getAllByAddressId(id);
    }

    @GetMapping("/companies")
    public List<Company> getAll() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/addresses")
    public List<AddressDto> getAllAddressDto() {
        return addressService.getDtoAddress();
    }

    @GetMapping("hello")
    public String getHello() {
        return "Hello, World";
    }


}
