package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        BrowserUtils.waitForPageToLoad(5);
        new AccountSummaryPage().navigateToModule("Pay Bills");
        BrowserUtils.waitFor(3);
        new PayBillsPage().navigateToTab("Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payeeNameInput,5);
        payBillsPage.payeeNameInput.sendKeys(dataTable.get("Payee Name"));
        payBillsPage.payeeAddressInput.sendKeys(dataTable.get("Payee Address"));
        payBillsPage.payeeAccountInput.sendKeys(dataTable.get("Account"));
        payBillsPage.payeeDetailsInput.sendKeys(dataTable.get("Payee details"));
        payBillsPage.PayeeAddBtn.click();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(new PayBillsPage().alertMessage.isDisplayed());
    }
}
