
Feature: Place the order for Products

@PlaceOrder
Scenario Outline: 
   Given User is on GreenCart Landing Page
   When user search with SortName called <Name> and extract actual name of product
   And Added "3" items of the selected product to cart
   Then User proceeds to Checkout and validate the <Name> items in checkout page
   And verify user has ability to enter promo code and place order
   
 Examples:
 |  Name |
 |  Tom  |
 |  Bro  |
   