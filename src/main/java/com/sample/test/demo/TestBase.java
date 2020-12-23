package com.sample.test.demo;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    private Configuration config;
    protected String url;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        config = new Configuration();
        url = config.getUrl();
        open(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWindow();
    }
}
