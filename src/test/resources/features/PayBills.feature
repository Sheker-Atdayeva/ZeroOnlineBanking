@paybills
Feature: Pay Bills page

#  Account Activity page should have the title Zero – Pay Bills. When user completes a
#  successful Pay operation, The payment was successfully submitted. should be
#  displayed. When user tries to make a payment without entering the amount or date,
#  Please fill out this field message! should be displayed.
#  Amount field should not accept alphabetical or special characters. Date field should
#  not accept alphabetical characters.
#  NOTE: . For the date input field you can just use sendKeys. No need to click on the date navigator.
  Background:
    Given the user is logged in
    When the user navigates to "Pay Bills" tab

  Scenario: Account Activity page title
    Then the "Pay Bills" page should have the title "Zero - Pay Bills"

  Scenario: Valid Payment operation
    When the user enters following datas to make a payment
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Amount      | 1000                        |
      | Date        | 2021-02-17                  |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then The payment was successfully submitted. should be displayed

  Scenario: Payment operation without entering amount
    When the user not enters amount datas
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Date        | 2021-02-17                  |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then Please fill out this field message! should be displayed on amount input

  Scenario: Invalid Payment operation
    When the user not enters date datas
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Amount      | 1000                        |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then Please fill out this field message! should be displayed on date input

  Scenario: Amount field should not accept alphabetical characters.
    When the user enters alphabetic characters to amount
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Amount      | absc                        |
      | Date        | 2021-02-17                  |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then Amount field should not accept alphabetical characters

  Scenario: Amount field should not accept special characters.
    When the user enters special characters to amount
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Amount      | $%^&*                       |
      | Date        | 2021-02-17                  |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then Amount field should not accept special characters

  Scenario: Date field should not accept alphabetical characters.
    When the user enters alphabetic characters to date
      | Payee       | Bank of America             |
      | Account     | Savings                     |
      | Amount      | 1000                        |
      | Date        | abcd                        |
      | Description | Payment for Bank of America |
    And clicks Pay
    Then Date field should not accept alphabetical characters


