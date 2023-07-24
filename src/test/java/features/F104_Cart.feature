Feature: Use Cart to add products
  Scenario: Add products to cart
    Given Search for product using and add the product to cart
      | Asus |  |
    When Notification bar is displayed
    Then User visit Cart to see the product

  Scenario: Edit Cart
      Given User can decides to continue search
      When User go back and remove product
      Then Cart became empty