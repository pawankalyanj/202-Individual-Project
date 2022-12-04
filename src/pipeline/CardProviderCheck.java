package pipeline;

import card.Card;

import java.io.IOException;

public class CardProviderCheck extends Stage {
    public CardProviderCheck(Card card) {
        super(card);
    }

    @Override
    public void process() throws IOException {
        if(this.card.isValid()){
            String cardNumber = this.card.getNumber();
            String digit1 = cardNumber.substring(0, 1);
            String digit2 = cardNumber.substring(0, 2);
            String digit4 = cardNumber.substring(0, 4);

            if (digit1.equals("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
                this.card.setVisa();
            }
            else if (digit2.compareTo("51") >= 0 && digit2.compareTo("55") <= 0 && cardNumber.length() == 16) {
                this.card.setMasterCard();
            }
            else if (digit4.equals("6011") && cardNumber.length() == 16) {
                this.card.setDiscover();
            }
            else if ((digit2.equals("34") || digit2.equals("37")) && cardNumber.length() == 15) {
                this.card.setAmericanExpress();
            }
            else {
                this.card.setError("Invalid: not a possible card number");
                this.card.setInvalid();
            }
        }
    }
}
