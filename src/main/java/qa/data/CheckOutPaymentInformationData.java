package qa.data;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * DEMO Version ONLY required FIELD are implemented !!!
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutPaymentInformationData {

    private String creditCardType;

    private String cardholderName;
    private String cardNumber;

    private String expirationMonth;
    private String expirationYear;

    private String cardCode;


 //############################################################################################################
//### METHODS ################################################################################################
//############################################################################################################

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
