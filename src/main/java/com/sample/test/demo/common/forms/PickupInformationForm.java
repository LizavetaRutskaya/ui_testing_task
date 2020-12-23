package com.sample.test.demo.common.forms;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.sample.test.demo.common.pages.OrderPage;


public class PickupInformationForm {

    private OrderPage parent;

    private SelenideElement form = $("#pickupInfo");
    private SelenideElement nameInput = form.$("#name");
    private SelenideElement emailInput = form.$("#email");
    private SelenideElement phoneInput = form.$("#phone");

    public PickupInformationForm(OrderPage parent) {
        this.parent = parent;
    }

    public OrderPage fillPickupDetails(String name, String email, String phone) {
        nameInput.setValue(name);
        emailInput.setValue(email);
        phoneInput.setValue(phone);
        return parent;
    }
}
