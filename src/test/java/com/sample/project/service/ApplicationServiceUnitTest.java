package com.sample.project.service;

import com.sample.project.repository.IApplicationRepository;
import com.sample.project.service.impl.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceUnitTest {

    @InjectMocks
    ApplicationService service;

    @Mock
    IApplicationRepository repository;

    @Test
    public void givenProperFileInput_thenSortOrder_ShouldInvokeDaoAtleastOnce() throws IOException {
        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
       service.sortOrders("C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\test\\resources\\srcData.txt", "C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\main\\resources\\dest.txt");
       verify(repository, times(1)).writeOrdersToFile(listCaptor.capture(), stringCaptor.capture());
       List<String> expectedList = Arrays.asList("MeatMeat        1477578289", "meatbread       1477578287", "pizza           1506176687");
       assertTrue(listCaptor.getValue().equals(expectedList));
       assertTrue(stringCaptor.getValue().equals("C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\main\\resources\\dest.txt"));
    }
}
