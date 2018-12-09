package com.syntax.cucumber.test.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/tannaznazar/eclipse-workspace/cucumberProject/src/test/resources/feature/Login.feature"
, glue= "")
public class LoginRunner {

	
}
