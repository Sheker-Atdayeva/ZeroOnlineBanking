package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(css = "div.offset2.span8>h2")
    public List<WebElement> accountTypes;

    public void openLink(String linkName){
        String linkLocator = "//table//a[.='" + linkName + "']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(linkLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(linkLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(linkLocator), 5);
        }

    }


}
