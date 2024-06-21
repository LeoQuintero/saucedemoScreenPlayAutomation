package com.co.choucair.stepdefinitions;

import com.co.choucair.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.co.choucair.utils.GlobalData.*;

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
    }
    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should be redirected to the inventory page")
    public void theUserShouldBeRedirectedToTheInventoryPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user should see the title {string}")
    public void theUserShouldSeeTheTitle(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
