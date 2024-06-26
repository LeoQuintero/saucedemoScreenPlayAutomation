package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PurchaseProducts implements Task {

    private final String action;
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public PurchaseProducts(String action) {
        this(action, null, null, null);
    }

    public PurchaseProducts(String action, String firstName, String lastName, String postalCode) {
        this.action = action;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static Task addFirstProduct() {
        return instrumented(PurchaseProducts.class, "addFirstProduct");
    }

    public static Task addSecondProduct() {
        return instrumented(PurchaseProducts.class, "addSecondProduct");
    }

    public static Task clickOnShoppingCartIcon() {
        return instrumented(PurchaseProducts.class, "clickOnShoppingCartIcon");
    }

    public static Task clickCheckoutButton() {
        return instrumented(PurchaseProducts.class, "Checkout");
    }

    public static Task clickContinueButton() {
        return instrumented(PurchaseProducts.class, "Continue");
    }

    public static Task clickFinishButton() {
        return instrumented(PurchaseProducts.class, "Finish");
    }

    public static Task enterUserInfo(String firstName, String lastName, String postalCode) {
        return instrumented(PurchaseProducts.class, "enterUserInfo", firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (action) {
            case "addFirstProduct":
                actor.attemptsTo(Click.on(CartPage.FIRST_PRODUCT));
                break;
            case "addSecondProduct":
                actor.attemptsTo(Click.on(CartPage.SECOND_PRODUCT));
                break;
            case "clickOnShoppingCartIcon":
                actor.attemptsTo(Click.on(CartPage.SHOPPING_CART_ICON));
                break;
            case "Checkout":
                actor.attemptsTo(Click.on(CartPage.CHECKOUT_BUTTON));
                break;
            case "Continue":
                System.out.println("Attempting to click on the Continue button...");
                actor.attemptsTo(
                        WaitUntil.the(CartPage.CONTINUE_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(CartPage.CONTINUE_BUTTON)
                );
                System.out.println("Clicked on the Continue button.");
                break;
            case "Finish":
                System.out.println("Attempting to click on the Finish button...");
                actor.attemptsTo(
                        WaitUntil.the(CartPage.FINISH_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(CartPage.FINISH_BUTTON)
                );
                System.out.println("Clicked on the Finish button.");
                break;
            case "enterUserInfo":
                System.out.println("Entering user information:");
                System.out.println("  - First Name: " + firstName);
                System.out.println("  - Last Name: " + lastName);
                System.out.println("  - Postal Code: " + postalCode);
                actor.attemptsTo(
                        Enter.theValue(firstName).into(CartPage.FIRST_NAME_FIELD),
                        Enter.theValue(lastName).into(CartPage.LAST_NAME_FIELD),
                        Enter.theValue(postalCode).into(CartPage.POSTAL_CODE_FIELD)
                );
                break;
            default:
                throw new IllegalArgumentException("Unknown action: " + action);
        }
    }
}
