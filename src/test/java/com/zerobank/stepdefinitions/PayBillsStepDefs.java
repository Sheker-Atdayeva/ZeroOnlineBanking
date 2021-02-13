package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefs {

    @When("the user enters following datas to make a payment")
    public void the_user_enters_following_datas_to_make_a_payment(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payAmountInput.sendKeys(paymentData.get("Amount"));
        payBillsPage.payDateInput.sendKeys(paymentData.get("Date"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @When("clicks Pay")
    public void clicks_Pay() {
        new PayBillsPage().payBtn.click();
    }

    @Then("The payment was successfully submitted. should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.paySubmittMessage,5);
        Assert.assertTrue(payBillsPage.paySubmittMessage.isDisplayed());
        Assert.assertEquals("The payment was successfully submitted.",payBillsPage.paySubmittMessage.getText());
    }

    @When("the user not enters amount datas")
    public void the_user_not_enters_amount_datas(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payDateInput.sendKeys(paymentData.get("Date"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @Then("Please fill out this field message! should be displayed on amount input")
    public void please_fill_out_this_field_message_should_be_displayed_on_amount_input() {
        BrowserUtils.waitFor(2);
        String expectedmessage = "Please fill out this field.";
        String actualmessage = new PayBillsPage().payAmountInput.getAttribute("validationMessage");
        Assert.assertEquals(expectedmessage,actualmessage);

    }

    @Then("Please fill out this field message! should be displayed on date input")
    public void please_fill_out_this_field_message_should_be_displayed_on_date_input() {
        BrowserUtils.waitFor(2);
        String expectedmessage = "Please fill out this field.";
        String actualmessage = new PayBillsPage().payDateInput.getAttribute("validationMessage");
        Assert.assertEquals(expectedmessage,actualmessage);

    }

    @When("the user not enters date datas")
    public void the_user_not_enters_date_datas(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payAmountInput.sendKeys(paymentData.get("Amount"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @When("the user enters alphabetic characters to amount")
    public void the_user_enters_alphabetic_characters_to_amount(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payAmountInput.sendKeys(paymentData.get("Amount"));
        payBillsPage.payDateInput.sendKeys(paymentData.get("Date"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @Then("Amount field should not accept alphabetical characters")
    public void amount_field_should_not_accept_alphabetical_characters() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(2);
        Assert.assertFalse("Verify that Amount field not accepts alphabetical characters",payBillsPage.paySubmittMessage.isDisplayed());
    }

    @When("the user enters special characters to amount")
    public void the_user_enters_special_characters_to_amount(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payAmountInput.sendKeys(paymentData.get("Amount"));
        payBillsPage.payDateInput.sendKeys(paymentData.get("Date"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @Then("Amount field should not accept special characters")
    public void amount_field_should_not_accept_special_characters() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(2);
        Assert.assertFalse("Verify that Amount field not accepts alphabetical characters",payBillsPage.paySubmittMessage.isDisplayed());
    }

    @When("the user enters alphabetic characters to date")
    public void the_user_enters_alphabetic_characters_to_date(Map<String, String> paymentData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.payPayeeDropdown,4);
        Select stateDropdown = new Select(payBillsPage.payPayeeDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Payee"));
        stateDropdown = new Select(payBillsPage.payAccountDropdown);
        stateDropdown.selectByVisibleText(paymentData.get("Account"));
        payBillsPage.payAmountInput.sendKeys(paymentData.get("Amount"));
        payBillsPage.payDateInput.sendKeys(paymentData.get("Date"));
        payBillsPage.payDescriptionInput.sendKeys(paymentData.get("Description"));
    }

    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {
        Assert.assertTrue(new PayBillsPage().payDateInput.getText().isBlank());
    }

}
