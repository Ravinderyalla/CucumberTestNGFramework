Feature: place an order

  Scenario: using default payment option

    Given I'm a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1 | city  | state | zip   | email         |
      | demo      | user     | United States (US) | 6300 Main St  | plano | Texas | 12345 | test@test.com |
    When I have a product in the cart
    And I'm on the checkout page
    When I provide billing details
    And i place an order
    Then the order should be placed successfully