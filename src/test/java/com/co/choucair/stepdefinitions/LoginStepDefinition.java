package com.co.choucair.stepdefinitions;

import com.co.choucair.questions.VerifyInventory;
import com.co.choucair.tasks.Login;
import com.co.choucair.utils.SessionState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.co.choucair.utils.GlobalData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinition {
    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the Sauce Demo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }
    @When("the user enters the username {string} and the password {string}")
    public void theUserEntersTheUsernameAndThePassword(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withCredentials(username,password));
        SessionState.setLoggedIn(true);
    }

    @Then("the user should be redirected to the inventory page")
    public void theUserShouldBeRedirectedToTheInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the page title is correct", VerifyInventory.withTitle("Products"), is(true))
        );
    }
    @And("the user should see the title {string}")
    public void theUserShouldSeeTheTitle(String expectedTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the page title is correct", VerifyInventory.withTitle(expectedTitle), is(true))
        );
    }
}
