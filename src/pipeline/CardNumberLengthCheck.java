package pipeline;

import card.Card;

import java.io.IOException;

public class CardNumberLengthCheck extends Stage{
    public CardNumberLengthCheck(Card card) {
        super(card);
    }

    @Override
    public void process() throws IOException {
        String cardNumber = this.card.getNumber();
        if(cardNumber == null || cardNumber.length() == 0){
            this.card.setError("Invalid: empty/null card number");
            this.card.setInvalid();
        }
        else if(cardNumber.length() > 19){
            this.card.setError("Invalid: more than 19 digits");
            this.card.setInvalid();
        }
        this.next.process();
    }
}
