package org.assignment;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses(ArraysComparatorTest.class)
@SuiteDisplayName("JUnit Test Suite")
public class JUnitTestSuite {
}
