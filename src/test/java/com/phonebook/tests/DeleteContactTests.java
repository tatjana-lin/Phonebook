package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Peter")
                .setLastName("Smith")
                .setPhone("10987654321")
                .setEmail("email1@email.com")
                .setAddress("Paderborn")
                .setDescription("OK"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactPositiveTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(500);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore -1);
    }
}
