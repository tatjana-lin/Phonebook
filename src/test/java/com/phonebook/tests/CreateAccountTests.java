package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{

//    Тест одноразовый!!! Больше не запускать! (аккаунт создан сразу после первого запуска)
@Test(enabled = false)
    public void createAccountPositiveTest(){
    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User()
            .setEmail("valid@email.com")
            .setPassword("ValidPass123$"));
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
}

    @Test
    public void createExistedAccountNegativeTest(){
        SoftAssert softAssert = new SoftAssert();

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnRegistrationButton();

        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isError409Present());
        softAssert.assertAll();
    }
}
