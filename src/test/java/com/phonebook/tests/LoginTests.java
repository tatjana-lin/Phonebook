package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
