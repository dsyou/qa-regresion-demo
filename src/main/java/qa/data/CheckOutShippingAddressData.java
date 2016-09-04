package qa.data;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * DEMO Version ONLY required FIELD are implemented !!!
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutShippingAddressData {

    private boolean ground_shipping_checkBox;
    private boolean nextDay_shipping_checkBox;

    private boolean secondDay_shipping_checkBox;


//############################################################################################################
//### METHODS ############################################################################################
//############################################################################################################

    public boolean isGround_shipping_checkBox() {
        return ground_shipping_checkBox;
    }

    public void setGround_shipping_checkBox(boolean ground_shipping_checkBox) {
        this.ground_shipping_checkBox = ground_shipping_checkBox;
    }

    public boolean isSecondDay_shipping_checkBox() {
        return secondDay_shipping_checkBox;
    }

    public void setSecondDay_shipping_checkBox(boolean secondDay_shipping_checkBox) {
        this.secondDay_shipping_checkBox = secondDay_shipping_checkBox;
    }

    public boolean isNextDay_shipping_checkBox() {
        return nextDay_shipping_checkBox;
    }

    public void setNextDay_shipping_checkBox(boolean nextDay_shipping_checkBox) {
        this.nextDay_shipping_checkBox = nextDay_shipping_checkBox;
    }
}
