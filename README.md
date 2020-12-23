# ui_testing_task readme file

Test Cases
========================

  - PICKUP INFORMATION missing fields validation  
  **Given**  
    User specifies order information  
    User fill Name/Phone/nothing in PICKUP INFORMATION  
    User choose Credit Card in PAYMENT INFORMATION  
  **When** User click Place Order button  
  **Then** System returns "Missing phone number"/"Missing name"/"Missing name Missing phone number" error message
  
  - Placing order  
  **Given**  
    User specifies order information  
    User fill PICKUP INFORMATION  
    User choose Credit Card in PAYMENT INFORMATION  
  **When** User click Place Order button  
  **Then** System return "Thank you for your order! TOTAL: ..." message
  
Test Cases with issues
----------------------
  - Only 1 payment system is available during placing order  
  **When** User choose Credit Card in PAYMENT INFORMATION  
  **Then** Cash on Pickup payment is unavailable for choose
  
  *Issue:* Pickup payment radio button allows both options to be chosen
 
  - All fields are getting reset after click Reset button  
  **Given**  
    User specifies order information  
    User fill PICKUP INFORMATION  
    User choose Credit Card in PAYMENT INFORMATION  
  **When** User click Reset button  
  **Then** All fields are getting set to their default values
  
  *Issue:* Toppings 1/Toppings 2 fields are not getting reset
  
  - Unable to enter negative Quantity number  
  **When**
    User specifies order information, tries to enter -1 as Quantity  
  **Then** 
    User unable to enter -1 as Quantity
    
  *Issue:* User is able to enter negative number as Quantity and Place order with negative Price
  
  - Order form is not editable while confirmation window is visible  
  **When**  
    User specified the order  
    User placed the order  
  **Then** 
    User unable to edit order form
      
  *Issue:* User is able to edit order form with confirmation window displayed
  
Issues dependent on the business logic
-----------------------------------

  - Pizza with 1/2 toppings does not really require these toppings to be selected from dropdown lists Toppings1/Toppings2, that looks confusing to user
  - Order occurs without order and payment information. System returns "Thank you for your order! TOTAL: 0" confirmation window