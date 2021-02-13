@summary
Feature: Account Summary page

#  Account summary page should have the title Zero – Account summary. Account
#  summary page should have to following account types: Cash Accounts, Investment
#  Accounts, Credit Accounts, Loan Accounts. Credit Accounts table must have columns
#  Account, Credit Card and Balance.

  Scenario: Account Summary page title
    Given the user is logged in
    When the user navigates to "Account Summary" tab
    Then the "Account Summary" page should have the title "Zero - Account Summary"
    And  the Account Summary page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

#    And "Credit Accounts" table must have following columns
#      | Account     |
#      | Credit Card |
#      | Balance     |
