Feature:
  Scenario:  User uses search for products
    Given User enters the data in search field
      | Apple MacBook Pro 13-inch |  |
    When User click on search to see the results
    Then User can see the product


  Scenario: User uses autocomplete search
    Given User enters the data
      | Asus |  |
    When User choose the autocomplete suggestions
    Then User can see the chosen product

