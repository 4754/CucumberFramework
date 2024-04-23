
Feature: Search and Place the order for products

@SearchProduct
Scenario Outline: Search Experiance for product search in both Home and Offers Page
   Given User is on GreenCart Landing Page
   When user search with SortName called <Name> and extract actual name of product
   Then user search for <Name> shortname in offers page to check if product exist with same name
Examples:
| Name |
| Tom  |
| Beet |
   