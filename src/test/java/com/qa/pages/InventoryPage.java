package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
    }

    public String getPageTitle() { return driver.findElement(pageTitle).getText(); }
    public int getProductCount() { return driver.findElements(inventoryItems).size(); }

    public InventoryPage addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpackButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return this;
    }

    public String getCartItemCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }

    public CartPage openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        return new CartPage(driver);
    }
}
