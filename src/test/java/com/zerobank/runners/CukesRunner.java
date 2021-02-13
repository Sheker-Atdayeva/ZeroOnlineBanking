package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"json:target/cucumber.json",
               "html:target/defauls-html-reports"
            },
    features ="src/test/resources/features",
    glue = "com/zerobank/stepdefinitions",
    dryRun = false,
    tags = "@findtrans"
)

public class CukesRunner {

}