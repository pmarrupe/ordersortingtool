package com.sample.project.service;

import com.sample.project.entity.Order;

import java.util.List;

public interface IApplicationService {

    List<Order> sortOrders(String srcFile, String destFile);
}
