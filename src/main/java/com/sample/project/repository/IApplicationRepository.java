package com.sample.project.repository;

import com.sample.project.entity.Order;

import java.util.List;

public interface IApplicationRepository {
    List<Order> writeOrdersToFile(List<String> sortedOrders, String destFile);
}
