$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FindTransactions.feature");
formatter.feature({
  "name": "Find Transactions in Account Activity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@findtrans"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefs.given_the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountActivityNavigationStepDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to \"Account Activity\" tab",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountSummaryStepDefs.the_user_navigates_to_tab(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user accesses the Find Transactions tab",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.the_user_accesses_the_Find_Transactions_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search date range",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@findtrans"
    },
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user enters date range from \"2012-09-01\" to \"2012-09-06\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.the_user_enters_date_range_from_to(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks search",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.clicks_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show transactions dates between \"2012-09-01\" to \"2012-09-06\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.results_table_should_only_show_transactions_dates_between_to(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results should be sorted by most recent date",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.the_results_should_be_sorted_by_most_recent_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters date range from \"2012-09-02\" to \"2012-09-06\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.the_user_enters_date_range_from_to(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks search",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.clicks_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show transactions dates between \"2012-09-02\" to \"2012-09-06\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.results_table_should_only_show_transactions_dates_between_to(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results table should only not contain transactions dated \"2012-09-01\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefs.the_results_table_should_only_not_contain_transactions_dated(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});