package com.example.demo.controller;

import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("companies")
public class CompanyController {

    private final ModelAndView mModelAndView = new ModelAndView();

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ModelAndView getCompany() {
        mModelAndView.setViewName("companyPage");
        mModelAndView.addObject("companyList", companyService.getAllCompanies());
        return mModelAndView;
    }



}
