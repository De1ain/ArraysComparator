package org.assignment.cucumber;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/assignment/cucumber")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.assignment.cucumber")
@SuiteDisplayName("Cucumber Test Suite")
public class CucumberTestSuite {
}