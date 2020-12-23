package com.sample.test.demo.tests;

import static com.codeborne.selenide.Selenide.page;
import static com.sample.test.demo.constants.PaymentTypes.CREDIT_CARD;
import static com.sample.test.demo.constants.PizzaToppings.MUSHROOMS;
import static com.sample.test.demo.constants.PizzaToppings.OLIVES;
import static com.sample.test.demo.constants.PizzaTypes.MEDIUM_TWOTOPPINGS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.common.pages.OrderPage;
import com.sample.test.demo.constants.PizzaTypes;


public class PickupInformationValidationTest extends TestBase {

    private static final PizzaTypes PIZZA = MEDIUM_TWOTOPPINGS;
    private static final String TOPPING1 = MUSHROOMS.getDisplayName();
    private static final String TOPPING2 = OLIVES.getDisplayName();
    private static final int QUANTITY = 1;
    private static final String USER_NAME = "test";
    private static final String EMAIL = "test@email.com";
    private static final String PHONE = "123";

    @DataProvider
    public Object[][] pickupInfoProvider() {
        return new Object[][]{{USER_NAME, "", "Missing phone number"},
                {"", PHONE, "Missing name"},
                {"", "", "Missing name Missing phone number"}};
    }

    @Test(dataProvider = "pickupInfoProvider")
    public void testPickupInformation(String name, String phone, String errorMessage) {
        OrderPage orderPage = page(OrderPage.class);
        orderPage.pizzaForm.selectPizzaDetails(PIZZA.getDisplayName(), TOPPING1, TOPPING2, QUANTITY)
                .pickupInformationForm.fillPickupDetails(name, EMAIL, phone)
                .paymentInformationForm.selectPaymentType(CREDIT_CARD)
                .clickPlaceOrder()
                .verifyAlertDialog(errorMessage);
    }
}
