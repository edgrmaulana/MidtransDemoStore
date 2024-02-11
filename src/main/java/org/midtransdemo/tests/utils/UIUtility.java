package org.midtransdemo.tests.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Component;
import net.serenitybdd.core.pages.WebElementFacade;

@Component("org.midtransdemo.tests.utils.UIUtility")
public class UIUtility extends PageObject {

    protected void clickByWebElementFacade(WebElementFacade webElementFacade){
        webElementFacade.click();
    }

    protected Boolean isElementVisibleByWeblementFacade(WebElementFacade webElementFacade){
        return webElementFacade.isVisible();
    }

    protected void switchToIFrame(){
        getDriver().switchTo().frame(
                getDriver().findElement(By.xpath("//iframe[contains(@src, 'sandbox.midtrans')]")));
    }

    protected void inputText(String text, WebElementFacade webElementFacade){
        webElementFacade.clear();
        webElementFacade.sendKeys(text);
    }

    protected void scrollPage(WebElementFacade webElementFacade){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElementFacade);
    }
}
