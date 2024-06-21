package com.co.choucair.userinterfaces;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target PAGE_TITLE = Target.the("page title")
            .located(By.className("product_label"));
}
