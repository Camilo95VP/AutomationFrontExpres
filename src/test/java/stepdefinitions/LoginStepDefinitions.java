package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import base.Base;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.expres.tasks.LoginExpresPage.loginExpresPage;
import static org.expres.tasks.OpenExpresPage.openExpresPage;

public class LoginStepDefinitions extends Base {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinitions.class.getName());
    private static final String ACTOR_NAME = "User";
    @Given("the user open expres page")
    public void theUserOpenExpresPage() {
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openExpresPage()
            );
    }

    @When("the user enter the username and password")
    public void theUserEnterTheUsernameAndPassword() {
        theActorCalled(ACTOR_NAME).attemptsTo(
               loginExpresPage()
        );
    }

    @Then("the user can see the admin module")
    public void theUserCanSeeTheAdminModule() {
    }
}
