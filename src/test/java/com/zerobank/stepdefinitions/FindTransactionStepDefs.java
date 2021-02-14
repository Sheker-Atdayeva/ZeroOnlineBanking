package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FindTransactionStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().FindTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        new AccountActivityPage().cleanAllBox();
        new AccountActivityPage().fromDateInput.sendKeys(fromDate);
        new AccountActivityPage().toDateInput.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(from);
        Date date2 = sdf.parse(to);
        Calendar fromDate = Calendar.getInstance();
        Calendar toDate = Calendar.getInstance();
        fromDate.setTime(date1);
        toDate.setTime(date2);
            for(String str: new AccountActivityPage().getTransactionDatesList()){
                Date now = sdf.parse(str);
                Calendar currentDate = Calendar.getInstance();
                currentDate.setTime(now);
                Assert.assertTrue(currentDate.after(fromDate));
                Assert.assertTrue(currentDate.before(toDate));
            }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar afterDate = Calendar.getInstance();
        Calendar beforeDate = Calendar.getInstance();
        for(int i=0; i< new AccountActivityPage().getTransactionDatesList().size()-1; i++ ){
            Date date1 = sdf.parse(new AccountActivityPage().getTransactionDatesList().get(i));
            Date date2 = sdf.parse(new AccountActivityPage().getTransactionDatesList().get(i+1));
            afterDate.setTime(date1);
            beforeDate.setTime(date2);
            Assert.assertTrue(afterDate.after(beforeDate));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String transactionDate) {
        for(String str: new AccountActivityPage().getTransactionDatesList()){
            Assert.assertNotEquals(str,transactionDate);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        new AccountActivityPage().cleanAllBox();
        new AccountActivityPage().descriptionInput.sendKeys(string+Keys.ENTER);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        for(String str: new AccountActivityPage().getTransactionDescriptionList()){
            Assert.assertTrue(str.contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for(String str: new AccountActivityPage().getTransactionDescriptionList()){
            Assert.assertFalse(str.contains(string));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(new AccountActivityPage().getDepositList().size()>=1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().getWithdrawalList().size()>=1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        new AccountActivityPage().clickType(type);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertEquals(0,new AccountActivityPage().getWithdrawalList().size());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertEquals(0,new AccountActivityPage().getDepositList().size());
    }

}
