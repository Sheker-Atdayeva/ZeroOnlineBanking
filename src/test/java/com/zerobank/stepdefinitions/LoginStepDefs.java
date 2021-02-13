package com.zerobank.stepdefinitions;

import com.zerobank.pages.ErrorPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void given_the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters the user informations")
    public void the_user_enters_the_user_informations() {
        new LoginPage().login();
        BrowserUtils.waitForPageToLoad(2);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("Zero - Account Summary", Driver.get().getTitle());
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        Assert.assertNotEquals("Zero - Account Summary", Driver.get().getTitle());
    }

    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("div.alert.alert-error")).isDisplayed());

    }
}
