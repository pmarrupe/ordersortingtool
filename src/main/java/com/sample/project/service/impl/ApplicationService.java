package com.sample.project.service.impl;

import com.sample.project.entity.Order;
import com.sample.project.repository.IApplicationRepository;
import com.sample.project.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    IApplicationRepository repository;

    @Override
    public List<Order> sortOrders(String srcFile, String destFile) {
        String line;
        List<String> sortedOrders = new ArrayList();
        try {
            FileReader fileReader =
                    new FileReader(srcFile);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                sortedOrders.add(line);
            }
            bufferedReader.close();
            Collections.sort(sortedOrders);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return repository.writeOrdersToFile(sortedOrders, destFile);
    }
}
