package org.midtransdemo.tests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.midtransdemo.tests.utils.UIUtility;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.pages.MidtransDemoPages")
public class MidtransDemoPages extends UIUtility {

    @FindBy(css = ".btn.buy")
    WebElementFacade buyNowButton;

    @FindBy(css = ".cart-checkout")
    WebElementFacade checkoutButton;

    @FindBy(css = "a[href='#/credit-card']")
    WebElementFacade creditCardPayment;

    @FindBy(css = ".valid-input-value[autocomplete='cc-number']")
    WebElementFacade creditCardNumber;

    @FindBy(css = "#card-expiry")
    WebElementFacade creditCardExpiry;

    @FindBy(css = "#card-cvv")
    WebElementFacade creditCardCvv;

    @FindBy(css = "label[for='no-promo'] span")
    WebElementFacade labelNoPromo;

    @FindBy(css = "label[for='690']")
    WebElementFacade labelFlashSalePromo;

    @FindBy(css = "button[type='button']")
    WebElementFacade payNowButton;



//    --------------- Click Action
    public void clickBuyNowButton(){
        clickByWebElementFacade(buyNowButton);
    }

    public void clickCheckoutButton(){
        clickByWebElementFacade(checkoutButton);
    }

    public void clickCreditcardPaymentMethod(){
        switchToIFrame();
        clickByWebElementFacade(creditCardPayment);
    }

    public void clickOnPromo(String value){
        if (value.equalsIgnoreCase("none")){
            clickByWebElementFacade(labelNoPromo);
        } else if (value.equalsIgnoreCase("with promo")){
            clickByWebElementFacade(labelFlashSalePromo);
        }
    }

    public void clickOnPayNow(){
        clickByWebElementFacade(payNowButton);
    }

//    --------------- Input Text Action
    public void inputCreditCardNumber(String value){
        inputText(value, creditCardNumber);
    }

    public void inputCreditCardExpiryDate(String value){
        inputText(value, creditCardExpiry);
    }

    public void inputCreditCardCvv(String value){
        inputText(value, creditCardCvv);
    }


//    --------------- Verify Action

    public void isPaymentMethodPageVisible(){
        isElementVisibleByWeblementFacade(creditCardPayment);
    }

//    --------------- Hover Action

    public void hoverToSeePromo(String value){
        if (value.equalsIgnoreCase("none")){
            scrollPage(labelNoPromo);
        } else if (value.equalsIgnoreCase("with promo")){
            scrollPage(labelFlashSalePromo);
        }
    }
}
