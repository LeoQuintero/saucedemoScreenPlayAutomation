package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target FIRST_PRODUCT = Target.the("first product").located(By.xpath("(//*/button[contains(@class,\"btn_primary btn_inventory\")])[1]"));
    public static final Target SECOND_PRODUCT = Target.the("second product").located(By.xpath("(//*/button[contains(@class,\"btn_primary btn_inventory\")])[2]"));
    public static final Target SHOPPING_CART_ICON  = Target.the("shoping cart icon").located(By.cssSelector(".svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x"));
    public static final Target CHECKOUT_BUTTON   = Target.the("checkout button").located(By.cssSelector("a.btn_action.checkout_button[href='./checkout-step-one.html']"));
    public static final Target FIRST_NAME_FIELD = Target.the("first name field").located(By.id("first-name"));
    public static final Target LAST_NAME_FIELD  = Target.the("last name field").located(By.id("last-name"));
    public static final Target POSTAL_CODE_FIELD = Target.the("postal code field").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button").located(By.xpath("(//*/input[contains(@class,\'btn_primary cart_button\')])"));
    public static final Target FINISH_BUTTON = Target.the("finish button").located(By.xpath("//a[@class='btn_action cart_button' and contains(text(), 'FINISH')]"));
    public static final Target ORDER_CONFIRMATION_MESSAGE = Target.the("order confirmation message").located(By.cssSelector(".complete-header"));
}
