public class VisaCC extends CreditCard {

    public VisaCC(String cardNumber) {
        super.number=cardNumber;
    }

    @Override
    public String toString() {
        return "VisaCC ["+super.number+"]";
    }

}