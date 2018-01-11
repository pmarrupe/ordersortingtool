package com.sample.project.controller;

import com.sample.project.service.impl.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerUnitTest {
    @InjectMocks
    ApplicationController controller;

    @Mock
    ApplicationService service;

    @Test
    public void whenOrderSortIsCalled_thenServiceEndpointIsInvokedAtleastOnce() {
        controller.sortOrders();
        verify(service, times(1)).sortOrders(anyString(), anyString());
    }
}
