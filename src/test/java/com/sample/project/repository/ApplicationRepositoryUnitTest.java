package com.sample.project.repository;

import com.sample.project.entity.Order_Product;
import com.sample.project.repository.impl.ApplicationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationRepositoryUnitTest {

    @InjectMocks
    ApplicationRepository repository;

    @Test
    public void whenProperListAndFileGiven_thenCorrectResult() {
        List<String> orderList = Arrays.asList("pizza1 1506176687", "meatpizza2 1477578287", "Bread 1477578287");
        List<Order_Product> resultList = repository.writeOrdersToFile(orderList, "C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\test\\resources\\testDest.txt");

        List<Order_Product> expectedList = Arrays.asList(new Order_Product("pizza1", 1506176687L),
                new Order_Product("meatpizza2", 1477578287L),
                new Order_Product("Bread", 1477578287L));

        assertTrue(resultList.equals(expectedList));
    }
}
