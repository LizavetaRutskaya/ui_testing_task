package com.sample.test.demo.tests;

import static com.codeborne.selenide.Selenide.page;
import static com.sample.test.demo.constants.PaymentTypes.CREDIT_CARD;
import static com.sample.test.demo.constants.PizzaToppings.MUSHROOMS;
import static com.sample.test.demo.constants.PizzaToppings.OLIVES;
import static com.sample.test.demo.constants.PizzaTypes.MEDIUM_TWOTOPPINGS;

import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.common.pages.OrderPage;
import com.sample.test.demo.constants.PizzaTypes;


public class PlaceOrderTest extends TestBase {

    private static final PizzaTypes PIZZA = MEDIUM_TWOTOPPINGS;
    private static final String TOPPING1 = MUSHROOMS.getDisplayName();
    private static final String TOPPING2 = OLIVES.getDisplayName();
    private static final int QUANTITY = 2;
    private static final String USER_NAME = "test";
    private static final String EMAIL = "test@email.com";
    private static final String PHONE = "123";

    @Test
    public void testPlaceOrder() {
        OrderPage orderPage = page(OrderPage.class);
        orderPage.pizzaForm.selectPizzaDetails(PIZZA.getDisplayName(), TOPPING1, TOPPING2, QUANTITY)
                .pickupInformationForm.fillPickupDetails(USER_NAME, EMAIL, PHONE)
                .paymentInformationForm.selectPaymentType(CREDIT_CARD)
                .pizzaForm.verifyPizzaCost(QUANTITY, PIZZA.getCost())
                .clickPlaceOrder()
                .verifyAlertDialog(QUANTITY, PIZZA);
    }
}
