package com.sample.test.demo.common.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.sample.test.demo.common.forms.PaymentInformationForm;
import com.sample.test.demo.common.forms.PickupInformationForm;
import com.sample.test.demo.common.forms.PizzaForm;
import com.sample.test.demo.constants.PizzaTypes;


public class OrderPage {

    private SelenideElement placeOrderButton = $("#placeOrder");
    private SelenideElement alertDialog = $(".ui-dialog");

    public PizzaForm pizzaForm = new PizzaForm(this);
    public PickupInformationForm pickupInformationForm = new PickupInformationForm(this);
    public PaymentInformationForm paymentInformationForm = new PaymentInformationForm(this);

    public OrderPage clickPlaceOrder() {
        placeOrderButton.click();
        return this;
    }

    public OrderPage verifyAlertDialog(int quantity, PizzaTypes pizzaType) {
        double price = quantity * pizzaType.getCost();
        return verifyAlertDialog(String.format("Thank you for your order! TOTAL: %s %s",
                price,
                pizzaType.getDisplayName()));
    }

    public OrderPage verifyAlertDialog(String message) {
        alertDialog.should(text(message));
        return this;
    }
}
