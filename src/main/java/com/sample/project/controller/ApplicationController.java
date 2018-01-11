package com.sample.project.controller;

import com.sample.project.entity.Order;
import com.sample.project.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApplicationController {

    @Value("${srcFile.name}")
    private String srcFile;

    @Value("${destFile.name}")
    private String destFile;

    @Autowired
    IApplicationService service;

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public List<Order> sortOrders(){
      return service.sortOrders(srcFile, destFile);
    }
}
