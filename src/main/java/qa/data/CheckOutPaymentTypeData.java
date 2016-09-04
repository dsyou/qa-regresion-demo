package qa.data;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * DEMO Version ONLY required FIELD are implemented !!!
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutPaymentTypeData {

    private boolean check_Order; //This Value is default

    private boolean creditCard_Order;

    private boolean purchase_Order;

    public boolean isCheck_Order() {
        return check_Order;
    }

    public void setCheck_Order(boolean check_Order) {
        this.check_Order = check_Order;
    }

    public boolean isPurchase_Order() {
        return purchase_Order;
    }

    public void setPurchase_Order(boolean purchase_Order) {
        this.purchase_Order = purchase_Order;
    }

    public boolean isCreditCard_Order() {
        return creditCard_Order;
    }

    public void setCreditCard_Order(boolean creditCard_Order) {
        this.creditCard_Order = creditCard_Order;
    }
}
