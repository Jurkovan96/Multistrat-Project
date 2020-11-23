package com.example.demo.restcontroller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Company;
import com.example.demo.entity.Internship;
import com.example.demo.entity.Student;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
        Student student = new Student();
        Timestamp date = new Timestamp(3281);
        student.setName("Beatrice");
        student.setSurname("Ciuta");
        student.setFaculty("FEAA");
        student.setBirthDate(date);
        student.setEmail("beatrice@gmail.com");
        student.setPassword("test1234");
        student.setPhoneNumber("39812721");
        studentService.insertWithEntityManager(student);
        return "Hello, World";
    }


}
