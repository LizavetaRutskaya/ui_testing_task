package com.sample.test.demo.common.forms;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.sample.test.demo.common.pages.OrderPage;


public class PizzaForm {

    private OrderPage parent;

    private SelenideElement form = $("#pizza1");
    private SelenideElement pizzaSelect = form.$("#pizza1Pizza");
    private SelenideElement toppingsSelect1 = form.$(".toppings1");
    private SelenideElement toppingsSelect2 = form.$(".toppings2");
    private SelenideElement pizzaQuantity = form.$("#pizza1Qty");
    private SelenideElement pizzaCost = form.$("#pizza1Cost");

    public PizzaForm(OrderPage parent) {
        this.parent = parent;
    }

    public OrderPage selectPizzaDetails(String pizza, String topping1, String topping2, int quantity) {
        pizzaSelect.selectOptionContainingText(pizza);
        toppingsSelect1.selectOption(topping1);
        toppingsSelect2.selectOption(topping2);
        pizzaQuantity.setValue(String.valueOf(quantity));
        return parent;
    }

    public OrderPage verifyPizzaCost(int quantity, double price) {
        pizzaCost.should(attribute("value", String.valueOf(quantity * price)));
        return parent;
    }
}
