package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Peter")
                .setLastName("Smith")
                .setPhone("10987654321")
                .setEmail("email1@email.com")
                .setAddress("Paderborn")
                .setDescription("OK"));

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded("Peter"));
    }

    @AfterMethod
public void postCondition(){
        app.getContact().removeContact();
        app.getContact().pause(1000);
}

}
