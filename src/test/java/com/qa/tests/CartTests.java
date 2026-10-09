package com.qa.tests;

import com.qa.pages.CartPage;
import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTests extends BaseTest {
    @Test
    @DisplayName("CT04 - Deve adicionar produto ao carrinho")
    void shouldAddProductToCart() {
        InventoryPage page = new LoginPage(driver).open()
                .loginAs("standard_user", "secret_sauce");
        page.addBackpackToCart();
        assertEquals("1", page.getCartItemCount());
    }

    @Test
    @DisplayName("CT05 - Deve exibir o produto adicionado no carrinho")
    void shouldDisplayAddedProductInCart() {
        InventoryPage inventory = new LoginPage(driver).open()
                .loginAs("standard_user", "secret_sauce");
        CartPage cart = inventory.addBackpackToCart().openCart();
        assertEquals("Your Cart", cart.getPageTitle());
        assertEquals(1, cart.getCartItemCount());
        assertEquals("Sauce Labs Backpack", cart.getFirstItemName());
    }
}
