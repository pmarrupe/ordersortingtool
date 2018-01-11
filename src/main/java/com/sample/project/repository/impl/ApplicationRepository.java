package com.sample.project.repository.impl;

import com.sample.project.entity.Order;
import com.sample.project.repository.IApplicationRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationRepository implements IApplicationRepository {

    private static final Logger logger = Logger.getLogger(ApplicationRepository.class);

    @Override
    public List<Order> writeOrdersToFile(List<String> sortedOrders, String destFile) {
        List<Order> entityList = new ArrayList<>();
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
            writer.write("order");
            writer.write("   ");
            writer.write("time");
            writer.newLine();

            sortedOrders.forEach(eachLine -> {
                try {
                    List<String> order = Arrays.asList(eachLine.split("\\s+"));
                    entityList.add(new Order(order.get(0), Long.parseLong(order.get(1))));
                    writer.write(eachLine);
                    writer.newLine();
                } catch (IOException e) {
                    logger.error("Exception while writing output to the destination file", e);
                }
            });
            writer.close();
        } catch (IOException e) {
            logger.error("Write to the file failed:", e);
        }
        return entityList;
    }
}