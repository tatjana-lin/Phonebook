package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
        // System.out.println("Home Component is " + isHomeComponentPresent());
        //      //div[2]/div/div/h1
    }

}