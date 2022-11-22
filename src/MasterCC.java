public class MasterCC extends CreditCard {

    public MasterCC(String cardNumber) {
        super.number=cardNumber;
    }

    @Override
    public String toString() {
        return "MasterCC ["+super.number+"]";
    }

}