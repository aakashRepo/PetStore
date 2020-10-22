package com.rest.petstore;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@petstore" }, glue = { "com.rest.petstore" }, monochrome = true, strict = true, plugin = {
	"pretty", "html:target/cucumber-reports/All", "json:target/cucumber-reports/All.json",
	"rerun:target/rerun.txt" }, features = "features/", dryRun = false)
public class Runner {
}
