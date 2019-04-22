package br.com.gx2.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        glue = "br.com.gx2.steps",
        features = {"src/test/resources/features/uolTest.feature"}
)

public class RunnerTest {
}
