package com.co.choucair.runners.login;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.co.choucair.stepdefinitions",
        tags = "@OrderedTests",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class LoginRunner {

}
