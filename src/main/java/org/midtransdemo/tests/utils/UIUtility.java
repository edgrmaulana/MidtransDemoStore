package org.midtransdemo.tests.utils;

import net.serenitybdd.core.pages.PageObject;
import org.htmlunit.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;
import net.serenitybdd.core.pages.WebElementFacade;

@Component("org.midtransdemo.tests.utils.UIUtility")
public class UIUtility extends PageObject {

    protected void clickByWebElementFacade(WebElementFacade webElementFacade){
        webElementFacade.click();
    }

    protected Boolean isElementVisibleByWebElementFacade(WebElementFacade webElementFacade){
        return webElementFacade.isVisible();
    }

    protected Boolean isElementDisabledByWebElementFacade(WebElementFacade webElementFacade){
        return webElementFacade.getAttribute("class").contains("disabled");
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

    protected void switchTo3DSIFrame(){
        getDriver().switchTo().frame(
                getDriver().findElement(By.xpath("//iframe[contains(@src, '3ds')]")));
    }

    protected String getTextByWebElementFacade(WebElementFacade webElementFacade){
        return webElementFacade.getText();
    }

    protected void deleteText(WebElementFacade webElementFacade){
        webElementFacade.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
}
