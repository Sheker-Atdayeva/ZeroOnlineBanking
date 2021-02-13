package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(css = "#np_new_payee_account")
    public WebElement payeeAccountInput;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetailsInput;

    @FindBy(css = "#add_new_payee")
    public WebElement PayeeAddBtn;

    @FindBy(css = "#alert_content")
    public WebElement alertMessage;

    @FindBy(xpath = "//div[@id='ui-tabs-3']/h2[@class='board-header']")
    public WebElement tabName;

    @FindBy(css = "#pc_currency>option")
    public List<WebElement> currencyOptions;

    @FindBy(css = "#purchase_cash")
    public WebElement purchaseBtn;

    @FindBy(css = "#pc_amount")
    public WebElement purchaseAmountInput;

    @FindBy(css = "#sp_payee")
    public WebElement payPayeeDropdown;

    @FindBy(css = "#sp_account")
    public WebElement payAccountDropdown;

    @FindBy(css = "#sp_amount")
    public WebElement payAmountInput;

    @FindBy(css = "#sp_date")
    public WebElement payDateInput;

    @FindBy(css = "#sp_description")
    public WebElement payDescriptionInput;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payBtn;

    @FindBy(css = "#alert_content>span")
    public WebElement paySubmittMessage;

    public void navigateToTab(String tabName){
        String tabLoctr = "//div[@id='tabs']//li[.='" + tabName +"']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLoctr), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLoctr));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLoctr), 5);
        }
    }
}
