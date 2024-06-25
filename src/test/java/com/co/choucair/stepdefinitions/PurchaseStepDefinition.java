package com.co.choucair.stepdefinitions;

import com.co.choucair.tasks.Login;
import com.co.choucair.utils.SessionState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;

public class PurchaseStepDefinition {

    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is logged in with the username {string} and the password {string}")
    public void theUserIsLoggedInWithTheUsernameAndThePassword(String username, String password) {
        if (!SessionState.isLoggedIn()) {
            OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
            OnStage.theActorInTheSpotlight().attemptsTo(Login.withCredentials(username,password));
            SessionState.setLoggedIn(true);
        }
    }
    @When("the user adds the first product to the cart")
    public void theUserAddsTheFirstProductToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user adds the second product to the cart")
    public void theUserAddsTheSecondProductToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user clicks on the shopping cart icon")
    public void theUserClicksOnTheShoppingCartIcon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user enters first name {string}, last name {string}, and postal code {string}")
    public void theUserEntersFirstNameLastNameAndPostalCode(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
