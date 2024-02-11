package org.midtransdemo.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.midtransdemo.tests.pages.MidtransDemoPages;
import org.midtransdemo.tests.properties.MidtransDemoProperties;
import org.midtransdemo.tests.utils.CommonUtility;

import java.io.IOException;

public class MidtransDemoSteps {

    MidtransDemoProperties midtransDemoProperties = new MidtransDemoProperties();

    CommonUtility commonUtility = new CommonUtility();

    MidtransDemoPages midtransDemoPages = new MidtransDemoPages();

    @Given("[midtransdemo] User tried to open midtrans store page")
    public void midtransdemoUserTriedToOpenMidtransStorePage() throws IOException {
        commonUtility.openPage(
                midtransDemoProperties.getProperties("defaultStoreUrl"));

    }

    //-------------- Click Action
    @When("[midtransdemo] User click on Buy Now")
    public void midtransdemoUserClickOnBuyNow() {
        midtransDemoPages.clickBuyNowButton();
    }

    @Then("[midtransdemo] User click on Checkout")
    public void midtransdemoUserClickOnCheckout() {
        midtransDemoPages.clickCheckoutButton();
    }

    @Then("[midtransdemo] user choose on Credit Card payment method")
    public void midtransdemoUserChooseOnCreditCardPaymentMethod() {
        midtransDemoPages.clickCreditcardPaymentMethod();
    }

    @Then("[midtransdemo] user click on pay now")
    public void midtransdemoUserClickOnPayNow() {
        midtransDemoPages.clickOnPayNow();
    }

    @And("[midtransdemo] user tried to use promo with type {string}")
    public void midtransdemoUserTriedToUsePromoWithTypePromoType(String value) {
        midtransDemoPages.hoverToSeePromo(value);
        midtransDemoPages.clickOnPromo(value);
    }

    //-------------- Type Action
    @And("[midtransdemo] user tried to input card number with number {string}")
    public void midtransdemoUserTriedToInputCardNumberWithNumberCardNumber(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? midtransDemoProperties.getProperties("cardNumber") : value;
        midtransDemoPages.inputCreditCardNumber(value);
    }

    @And("[midtransdemo] user tried to input expiration date with date {string}")
    public void midtransdemoUserTriedToInputExpirationDateWithDateExpirationDate(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? midtransDemoProperties.getProperties("expirationDate") : value;
        midtransDemoPages.inputCreditCardExpiryDate(value);
    }

    @And("[midtransdemo] user tried to input cvv with code {string}")
    public void midtransdemoUserTriedToInputCvvWithCodeCvv(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? midtransDemoProperties.getProperties("cvv") : value;
        midtransDemoPages.inputCreditCardCvv(value);
    }

    @And("[midtransdemo] user tried to input transaction token with code {string}")
    public void midtransdemoUserTriedToInputTransactionTokenWithCodeToken(String value) {
    }

    //-------------- Verify Element
    @And("[midtransdemo] payment method popup should be showing up")
    public void midtransdemoPaymentMethodPopupShouldBeShowingUp() {
        midtransDemoPages.isPaymentMethodPageVisible();
    }

    @Then("[midtransdemo] 3ds popup should be showing up")
    public void midtransdemoDsPopupShouldBeShowingUp() {
    }

    @And("[midtransdemo] verify that user card number is correct")
    public void midtransdemoVerifyThatUserCardNumberIsCorrect() {

    }

    @And("[midtransdemo] verify that user amount paid is correct")
    public void midtransdemoVerifyThatUserAmountPaidIsCorrect() {

    }

    @Then("[midtransdemo] payment successful popup should be showing up")
    public void midtransdemoPaymentSuccessfulPopupShouldBeShowingUp() {

    }

    @Then("[midtransdemo] user should be redirected to home page")
    public void midtransdemoUserShouldBeRedirectedToHomePage() {

    }

    @And("[midtransdemo] thankyou notification should be showing up")
    public void midtransdemoThankyouNotificationShouldBeShowingUp() {
    }

    @Then("[midtransdemo] User wait for {int} second")
    public void midtransdemoUserWaitForSecond(int value) throws InterruptedException {
        Thread.sleep(value * 1000L);
    }
}
