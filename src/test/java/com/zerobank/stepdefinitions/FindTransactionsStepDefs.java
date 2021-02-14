package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {
        new AccountSummaryPage().navigateToModule("Account Activity");
        new AccountActivityPage().FindTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateInput.sendKeys(fromDate);
        accountActivityPage.toDateInput.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(4);
        new AccountActivityPage().cleanAllBox();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date from = sdf.parse(fromDate);
        Date to = sdf.parse(toDate);
        for(String str: new AccountActivityPage().getTransactionDatesList()){
            Date now = sdf.parse(str);
            Assert.assertTrue(now.compareTo(from)<0);
            Assert.assertTrue(now.compareTo(to)>0);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> transactionDates = new AccountActivityPage().getTransactionDatesList();
        for(int i=0; i<transactionDates.size()-1; i++){
            Date now = sdf.parse(transactionDates.get(i));
            Date before = sdf.parse(transactionDates.get(i+1));
            System.out.println("now = " + now);
            System.out.println("before = " + before);
            Assert.assertTrue(now.compareTo(before)<0);
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String transDate) {
        List<String> transactionDates = new AccountActivityPage().getTransactionDatesList();
        for(String actualDate: transactionDates){
            Assert.assertNotEquals(transDate,actualDate,"Verify that table doesn't contain transaction date");
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        new AccountActivityPage().descriptionInput.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String expectedDescription) {
        for(String actualDescription: new AccountActivityPage().getTransactionDescriptionList()){
            if(!actualDescription.contains(expectedDescription)) {
                System.out.println("actualDescription = " + actualDescription);
            }
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String nonExpectedDescription) {
        System.out.println(new AccountActivityPage().getTransactionDescriptionList().size());
        for(String actualDescription: new AccountActivityPage().getTransactionDescriptionList()){
            if(actualDescription.contains(nonExpectedDescription)) {
                System.out.println("actualDescription = " + actualDescription);
            }
        }

    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        System.out.println(new AccountActivityPage().getDepositList().size());
        Assert.assertTrue(new AccountActivityPage().getDepositList().size()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        System.out.println(new AccountActivityPage().getWithdrawalList().size());
        Assert.assertTrue(new AccountActivityPage().getWithdrawalList().size()>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String selectType) {
        new AccountActivityPage().getType(selectType);
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
