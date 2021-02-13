@accountactivity
Feature:Account Activity page

#  Account Activity page should have the title Zero – Account activity.
#  In the Account drop down default option should be Savings. Account drop down
#  should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
#  Transactions table should have column names Date, Description, Deposit,
#  Withdrawal.
  Scenario: Account Activity page Account drop down should
    Given the user is logged in
    When the user navigates to "Account Activity" tab
    Then the "Account Activity" page should have the title "Zero - Account Activity"
    And Account drop down should have "Savings" selected
    And Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Account Activity page Transactions table
    Given the user is logged in
    When the user navigates to "Account Activity" tab
    And Transactions table should have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |