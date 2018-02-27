package com.sample.project.service;

import com.sample.project.entity.Order_Product;

import java.util.List;

public interface IApplicationService {

    List<Order_Product> sortOrders(String srcFile, String destFile);
}
