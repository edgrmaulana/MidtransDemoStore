package org.midtransdemo.tests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.midtransdemo.tests.utils.UIUtility;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.pages.MidtransDemoPages")
public class MidtransDemoPages extends UIUtility {

    @FindBy(css = ".btn.buy")
    WebElementFacade buyNowButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade emailInCheckout;

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

    @FindBy(css = "#otp")
    WebElementFacade otpToken;

    @FindBy(css = ".header-amount")
    WebElementFacade headerAmount;

    @FindBy(css = "#txn_amount")
    WebElementFacade transactionAmount;

    @FindBy(css = "#card_number")
    WebElementFacade cardNumber;

    @FindBy(css = "button[value='ok']")
    WebElementFacade payNow3DS;

    @FindBy(xpath = "//span[normalize-space()='Thank you for your purchase.']")
    WebElementFacade thankyouHomepage;

    @FindBy(xpath = "//span[normalize-space()='Sorry, something went wrong.']")
    WebElementFacade errorHomepage;

    @FindBy(css = ".cancel-modal-title")
    WebElementFacade paymentDeclined;

    @FindBy(css = ".card-warning.text-failed")
    WebElementFacade cardErrorNotification;


//    --------------- Click Action
    public void clickBuyNowButton(){
        clickByWebElementFacade(buyNowButton);
    }

    public void clickCheckoutButton(){
        clickByWebElementFacade(checkoutButton);
    }

    public void clickCreditcardPaymentMethod(){
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

    public void clickOn3DSPayNow(){
        clickByWebElementFacade(payNow3DS);
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

    public void inputOtpToken(String value){
        inputText(value, otpToken);
    }

    public void deleteEmailText(){
        deleteText(emailInCheckout);
    }


//    --------------- Verify Action

    public Boolean isPaymentMethodPageVisible(){
        switchToIFrame();
        return isElementVisibleByWebElementFacade(creditCardPayment);
    }

    public Boolean is3dsPageVisible(){
        switchTo3DSIFrame();
        return isElementVisibleByWebElementFacade(otpToken);
    }

    public Boolean isThankyouInHomepageVisible(){
        return isElementVisibleByWebElementFacade(thankyouHomepage);
    }

    public Boolean isPaymentDeclinedPopupVisible(String value){
        if (value.equalsIgnoreCase("Payment declined by bank")){
            switchToIFrame();
        }
        return isElementVisibleByWebElementFacade(paymentDeclined);
    }

    public Boolean isErrorHomepageNotificationVisible(){
        return isElementVisibleByWebElementFacade(errorHomepage);
    }

    public Boolean isPayNowButtonDisabled(){
        return isElementDisabledByWebElementFacade(payNowButton);
    }

    public Boolean isCardErrorWarningVisible(){
        return isElementVisibleByWebElementFacade(cardErrorNotification);
    }

//    --------------- Hover Action

    public void hoverToSeePromo(String value){
        if (value.equalsIgnoreCase("none")){
            scrollPage(labelNoPromo);
        } else if (value.equalsIgnoreCase("with promo")){
            scrollPage(labelFlashSalePromo);
        }
    }

    //    --------------- Get Text Action

    public String getHeaderAmount(){
        return getTextByWebElementFacade(headerAmount);
    }

    public String getTransactionAmount(){
        return getTextByWebElementFacade(transactionAmount);
    }

    public String getCreditCardNumber(){
        return getTextByWebElementFacade(cardNumber);
    }

    public String getPaymentDeclinedText(){
        return getTextByWebElementFacade(paymentDeclined);
    }

    public String getErrorMessageHomepage(){
        return getTextByWebElementFacade(errorHomepage);
    }

    public String getCardErrorMessage(){
        return getTextByWebElementFacade(cardErrorNotification);
    }
}
