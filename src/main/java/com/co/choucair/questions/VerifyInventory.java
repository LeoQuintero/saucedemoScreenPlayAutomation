package com.co.choucair.questions;

import com.co.choucair.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyInventory implements Question {
    private final String expectedTitle;

    public VerifyInventory(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    public static VerifyInventory withTitle(String expectedTitle) {
        return new VerifyInventory(expectedTitle);
    }

    @Override
    public Object answeredBy(Actor actor) {
        String actualTitle = InventoryPage.PAGE_TITLE.resolveFor(actor).getText();
        return actualTitle.equals(expectedTitle);
    }
}
