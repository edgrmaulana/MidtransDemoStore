@MidtransDemoStoreFeature

Feature: Automation UI Testing for Midtrans Demo Store Feature

  Background:
    Given [midtransdemo] User tried to open midtrans store page

  @Positive
  Scenario Outline:
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User click on Checkout
    And  [midtransdemo] payment method popup should be showing up
    Then [midtransdemo] user choose on Credit Card payment method
    And  [midtransdemo] user tried to input card number with number '<cardNumber>'
    And  [midtransdemo] user tried to input expiration date with date '<expirationDate>'
    And  [midtransdemo] user tried to input cvv with code '<cvv>'
    And  [midtransdemo] user tried to use promo with type '<promoType>'
    Then [midtransdemo] user click on pay now
    Then [midtransdemo] 3ds popup should be showing up
    And  [midtransdemo] user tried to input transaction token with code '<token>'
    And  [midtransdemo] verify that user card number is correct
    And  [midtransdemo] verify that user amount paid is correct
    Then [midtransdemo] payment successful popup should be showing up
    Then [midtransdemo] user should be redirected to home page
    And  [midtransdemo] thankyou notification should be showing up


    Examples:
      | cardNumber  | expirationDate  | cvv     | token   | promoType |
      | default     | default         | default | default |           |