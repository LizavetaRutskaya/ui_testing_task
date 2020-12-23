package com.sample.test.demo.common.forms;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.sample.test.demo.common.pages.OrderPage;
import com.sample.test.demo.constants.PaymentTypes;


public class PaymentInformationForm {

    private OrderPage parent;

    private SelenideElement form = $("#paymentSection");
    private SelenideElement creditCardRadio = form.$("#ccpayment");
    private SelenideElement cashRadio = form.$("#cashpayment");

    public PaymentInformationForm(OrderPage parent) {
        this.parent = parent;
    }

    public OrderPage selectPaymentType(PaymentTypes paymentType) {
        switch (paymentType) {
            case CREDIT_CARD:
                creditCardRadio.click();
                break;
            case CASH:
                cashRadio.click();
                break;
            default:
                throw new IllegalArgumentException("Undefined payment type: " + paymentType.getDisplayName());
        }
        return parent;
    }
}
