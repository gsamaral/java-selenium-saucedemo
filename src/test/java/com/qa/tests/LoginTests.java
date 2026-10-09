package com.qa.tests;

import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTests extends BaseTest {
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";

    @Test
    @DisplayName("CT01 - Deve fazer login com credenciais válidas")
    void shouldLoginWithValidCredentials() {
        InventoryPage page = new LoginPage(driver).open().loginAs(VALID_USER, VALID_PASSWORD);
        assertEquals("Products", page.getPageTitle());
        assertTrue(page.getProductCount() > 0, "A página deve apresentar produtos.");
    }

    @Test
    @DisplayName("CT02 - Deve exibir mensagem para senha inválida")
    void shouldShowErrorForInvalidPassword() {
        LoginPage page = new LoginPage(driver).open()
                .loginExpectingError(VALID_USER, "wrong_password");
        assertTrue(page.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    @DisplayName("CT03 - Deve exigir usuário ao tentar fazer login")
    void shouldRequireUsername() {
        LoginPage page = new LoginPage(driver).open()
                .loginExpectingError("", VALID_PASSWORD);
        assertTrue(page.getErrorMessage().contains("Username is required"));
    }
}
