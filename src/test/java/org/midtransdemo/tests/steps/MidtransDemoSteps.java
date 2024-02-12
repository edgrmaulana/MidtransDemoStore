package org.midtransdemo.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.midtransdemo.tests.data.MidtransDemoData;
import org.midtransdemo.tests.pages.MidtransDemoPages;
import org.midtransdemo.tests.properties.MidtransDemoProperties;
import org.midtransdemo.tests.utils.CommonUtility;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class MidtransDemoSteps {

    MidtransDemoProperties midtransDemoProperties = new MidtransDemoProperties();

    CommonUtility commonUtility = new CommonUtility();

    MidtransDemoPages midtransDemoPages = new MidtransDemoPages();

    MidtransDemoData midtransDemoData = new MidtransDemoData();

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
        midtransDemoData.setHeaderAmount(
                midtransDemoPages.getHeaderAmount());

        midtransDemoPages.clickOnPayNow();
    }

    @And("[midtransdemo] user tried to use promo with type {string}")
    public void midtransdemoUserTriedToUsePromoWithTypePromoType(String value) {
        midtransDemoPages.hoverToSeePromo(value);
        midtransDemoPages.clickOnPromo(value);
    }

    @Then("[midtransdemo] user tried to click Pay Now in 3DS")
    public void midtransdemoUserTriedToClickPayNowIn3DS() {
        midtransDemoPages.clickOn3DSPayNow();
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

    @Then("[midtransdemo] User tried to put empty email")
    public void midtransdemoUserTriedToPutEmptyEmail() {
        midtransDemoPages.deleteEmailText();
    }

    @And("[midtransdemo] user tried to input cvv with code {string}")
    public void midtransdemoUserTriedToInputCvvWithCodeCvv(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? midtransDemoProperties.getProperties("cvv") : value;
        midtransDemoPages.inputCreditCardCvv(value);
    }

    @And("[midtransdemo] user tried to input transaction token with code {string}")
    public void midtransdemoUserTriedToInputTransactionTokenWithCodeToken(String value) throws IOException {
        value = value.equalsIgnoreCase("default") ? midtransDemoProperties.getProperties("token") : value;
        midtransDemoPages.inputOtpToken(value);
    }

    //-------------- Verify Element
    @And("[midtransdemo] payment method popup should be showing up")
    public void midtransdemoPaymentMethodPopupShouldBeShowingUp() {
        assertThat("Page is not showing up", midtransDemoPages.isPaymentMethodPageVisible(),
                equalTo(true));
    }

    @Then("[midtransdemo] 3ds popup should be showing up")
    public void midtransdemoDsPopupShouldBeShowingUp() {
        assertThat("Page is not showing up", midtransDemoPages.is3dsPageVisible(),
                equalTo(true));
    }

    @And("[midtransdemo] verify that user card number is correct")
    public void midtransdemoVerifyThatUserCardNumberIsCorrect() throws IOException {
        String cardNumber = midtransDemoPages.getCreditCardNumber();
        String inputCardNumber = midtransDemoProperties.getProperties("cardNumber");

        assertThat("First 6 digits of card number is mismatch", cardNumber.substring(0,6),
                equalTo(inputCardNumber.substring(0,6)));

        assertThat("End 4 digits of card number is mismatch", cardNumber.substring(cardNumber.length() - 4),
                equalTo(inputCardNumber.substring(inputCardNumber.length() - 4)));
    }

    @And("[midtransdemo] verify that user amount paid is correct")
    public void midtransdemoVerifyThatUserAmountPaidIsCorrect() {
        midtransDemoData.setTransactionAmount(midtransDemoPages.getTransactionAmount());

        String transactionAmount = midtransDemoData.getTransactionAmount().replaceAll("[^0-9]", "");

        assertThat("Amount that need to be paid and charged is different",
                transactionAmount.substring(0, transactionAmount.length() - 2),
                equalTo(midtransDemoData.getHeaderAmount().replaceAll("[^0-9]", "")));

    }

    @And("[midtransdemo] thankyou notification should be showing up")
    public void midtransdemoThankyouNotificationShouldBeShowingUp() {
        assertThat("Payment Success notification in homepage is not visible",
                midtransDemoPages.isThankyouInHomepageVisible(),
                equalTo(true));
    }

    @Then("[midtransdemo] User wait for {int} second")
    public void midtransdemoUserWaitForSecond(int value) throws InterruptedException {
        Thread.sleep(value * 1000L);
    }

    @And("[midtransdemo] error message for payment declined should be showing up with error message {string}")
    public void midtransdemoErrorMessageForPaymentDeclinedShouldBeShowingUpWithErrorMessage(String value) {
        assertThat("Payment Declined popup is not visible",
                midtransDemoPages.isPaymentDeclinedPopupVisible(value),
                equalTo(true));

        assertThat("Payment declined message is incorrect",
                midtransDemoPages.getPaymentDeclinedText(),
                containsString(value));
    }

    @And("[midtransdemo] error message for failed checkout should be showing up")
    public void midtransdemoErrorMessageForFailedCheckoutShouldBeShowingUp() {
        assertThat("Error notification is not showing up",
                midtransDemoPages.isErrorHomepageNotificationVisible(),
                equalTo(true));

        assertThat("Error message is Incorrect",
                midtransDemoPages.getErrorMessageHomepage(),
                containsString("Sorry, something went wrong."));
    }

    @Then("[midtransdemo] pay now button should be disabled")
    public void midtransdemoPayNowButtonShouldBeDisabled() {
        assertThat("Pay Now Button is Not Disabled",
                midtransDemoPages.isPayNowButtonDisabled(),
                equalTo(true));
    }

    @Then("[midtransdemo] card error warning should be showing up with error message {string}")
    public void midtransdemoCardErrorWarningShouldBeShowingUpWithErrorMessage(String value) {
        assertThat("Card Error Warning is not visible",
                midtransDemoPages.isCardErrorWarningVisible(),
                equalTo(true));

        assertThat("Card Error Warning Message is Incorrect",
                midtransDemoPages.getCardErrorMessage(),
                containsString(value));
    }
}
