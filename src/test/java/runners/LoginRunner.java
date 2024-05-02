package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "C:\\PROGRAMACION\\ExpresFrontAutomation\\src\\test\\resources\\features\\login.feature",
        glue = "stepdefinitions",
        tags = "@LOGIN",
        plugin = {"pretty"}
)
public class LoginRunner {
}
