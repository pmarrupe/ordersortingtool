package com.sample.project.controller;

import com.sample.project.Application;
import org.junit.Test;

public class ApplicationLiveTest {

    @Test
    public void testApplication()
    {
        try {
            Application.main(new String[]{
                    "--srcFile.name=C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\main\\resources\\src.txt",
                    "--destFile.name=C:\\Users\\prashanth\\IdeaProjects\\ordersortingtool\\src\\main\\resources\\dest.txt",
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
