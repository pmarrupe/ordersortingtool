package com.sample.project.repository;

import com.sample.project.entity.Order_Product;

import java.util.List;

public interface IApplicationRepository {
    List<Order_Product> writeOrdersToFile(List<String> sortedOrders, String destFile);
}
