public class DiscoverCC extends CreditCard {

    public DiscoverCC(String cardNumber) {
        super.number=cardNumber;
    }

    @Override
    public String toString() {
        return "DiscoverCC ["+super.number+"]";
    }

}