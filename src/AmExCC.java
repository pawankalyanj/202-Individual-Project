public class AmExCC extends CreditCard {

    public AmExCC(String cardNumber) {
        super.number=cardNumber;
    }

    @Override
    public String toString() {
        return "AmExCC ["+super.number+"]";
    }

}