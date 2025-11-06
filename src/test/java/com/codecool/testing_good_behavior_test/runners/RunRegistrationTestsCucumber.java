package com.codecool.testing_good_behavior_test.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")   // path under src/test/resources
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.codecool.testing_good_behavior_test.steps,com.codecool.testing_good_behavior_test.hooks")
public class RunRegistrationTestsCucumber { }
