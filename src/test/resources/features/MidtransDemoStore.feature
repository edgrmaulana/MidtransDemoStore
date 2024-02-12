@MidtransDemoStoreFeature

Feature: Automation UI Testing for Midtrans Demo Store Feature

  Background:
    Given [midtransdemo] User tried to open midtrans store page

  @Positive
  Scenario Outline: Verify Midtrans Demo Store Page with '<reason>'
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User click on Checkout
    Then [midtransdemo] User wait for 2 second
    And  [midtransdemo] payment method popup should be showing up
    Then [midtransdemo] user choose on Credit Card payment method
    And  [midtransdemo] user tried to input card number with number '<cardNumber>'
    And  [midtransdemo] user tried to input expiration date with date '<expirationDate>'
    And  [midtransdemo] user tried to input cvv with code '<cvv>'
    And  [midtransdemo] user tried to use promo with type '<promoType>'
    Then [midtransdemo] user click on pay now
    Then [midtransdemo] User wait for 5 second
    Then [midtransdemo] 3ds popup should be showing up
    And  [midtransdemo] verify that user card number is correct
    And  [midtransdemo] verify that user amount paid is correct
    And  [midtransdemo] user tried to input transaction token with code '<token>'
    Then [midtransdemo] user tried to click Pay Now in 3DS
    Then [midtransdemo] User wait for 5 second
    And  [midtransdemo] thankyou notification should be showing up


    Examples:
      | cardNumber  | expirationDate  | cvv     | token   | promoType   | reason              |
      | default     | default         | default | default | none        | user without promo  |
      | default     | default         | default | default | with promo  | user with promo     |

  @Negative
  Scenario Outline: Transaction in Midtrans Demo Store Page should be failed because of '<reason>'
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User click on Checkout
    Then [midtransdemo] User wait for 2 second
    And  [midtransdemo] payment method popup should be showing up
    Then [midtransdemo] user choose on Credit Card payment method
    And  [midtransdemo] user tried to input card number with number '<cardNumber>'
    And  [midtransdemo] user tried to input expiration date with date '<expirationDate>'
    And  [midtransdemo] user tried to input cvv with code '<cvv>'
    And  [midtransdemo] user tried to use promo with type '<promoType>'
    Then [midtransdemo] user click on pay now
    Then [midtransdemo] User wait for 5 second
    Then [midtransdemo] 3ds popup should be showing up
    And  [midtransdemo] verify that user card number is correct
    And  [midtransdemo] verify that user amount paid is correct
    And  [midtransdemo] user tried to input transaction token with code '<token>'
    Then [midtransdemo] user tried to click Pay Now in 3DS
    Then [midtransdemo] User wait for 5 second
    And  [midtransdemo] error message for payment declined should be showing up with error message '<errorMessage>'


    Examples:
      | cardNumber  | expirationDate  | cvv     | token   | promoType   | errorMessage              | reason        |
      | default     | default         | default | 123456  | none        | Payment declined by bank  | incorrect 3DS |

  @Negative
  Scenario Outline: Transaction in Midtrans Demo Store Page should be failed because of '<reason>'
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User click on Checkout
    Then [midtransdemo] User wait for 2 second
    And  [midtransdemo] payment method popup should be showing up
    Then [midtransdemo] user choose on Credit Card payment method
    And  [midtransdemo] user tried to input card number with number '<cardNumber>'
    And  [midtransdemo] user tried to input expiration date with date '<expirationDate>'
    And  [midtransdemo] user tried to input cvv with code '<cvv>'
    And  [midtransdemo] user tried to use promo with type '<promoType>'
    Then [midtransdemo] pay now button should be disabled
    Then [midtransdemo] card error warning should be showing up with error message '<errorWarning>'

    Examples:
      | cardNumber  | expirationDate  | cvv     | promoType   | errorWarning                            | reason                |
      | default     | 1111            | default | none        | Invalid expiry.                         | incorrect expiryDate  |
      | 4811111111  | default         | default | none        | Make sure your card info is correct.    | incorrect cardNumber  |

  @Negative @asd
  Scenario Outline: Transaction in Midtrans Demo Store Page should be failed because of '<reason>'
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User click on Checkout
    Then [midtransdemo] User wait for 2 second
    And  [midtransdemo] payment method popup should be showing up
    Then [midtransdemo] user choose on Credit Card payment method
    And  [midtransdemo] user tried to input card number with number '<cardNumber>'
    And  [midtransdemo] user tried to input expiration date with date '<expirationDate>'
    And  [midtransdemo] user tried to input cvv with code '<cvv>'
    And  [midtransdemo] user tried to use promo with type '<promoType>'
    Then [midtransdemo] user click on pay now
    Then [midtransdemo] User wait for 5 second
    And  [midtransdemo] error message for payment declined should be showing up with error message '<errorMessage>'


    Examples:
      | cardNumber  | expirationDate  | cvv     | promoType   | errorMessage          | reason        |
      | default     | default         | 123456  | none        | Invalid payment data  | incorrect cvv |

  @Negative
  Scenario Outline: Transaction in Midtrans Demo Store Page should be failed because of '<reason>'
    When [midtransdemo] User click on Buy Now
    Then [midtransdemo] User tried to put empty email
    Then [midtransdemo] User click on Checkout
    And  [midtransdemo] error message for failed checkout should be showing up

    Examples:
      | reason          |
      | incorrect email |
  ## wrong cvv,