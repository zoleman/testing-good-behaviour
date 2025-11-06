package com.codecool.testing_good_behavior_test.hooks;

import com.codecool.testing_good_behavior_test.base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setUp() {
        System.out.println(">>> @Before HOOK: Starting scenario");
        DriverManager.getDriver();  // just create driver before scenario
    }

    @After
    public void tearDown() {
        System.out.println(">>> @After HOOK: Closing browser");
        DriverManager.closeDriver(); // close it after scenario
    }
}
