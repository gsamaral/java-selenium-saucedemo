package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By cartItems = By.cssSelector(".cart_item");
    private final By itemName = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
    }

    public String getPageTitle() { return driver.findElement(pageTitle).getText(); }
    public int getCartItemCount() { return driver.findElements(cartItems).size(); }
    public String getFirstItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemName)).getText();
    }
}
