package pipeline;

import card.Card;

import java.io.IOException;

public class InvalidCharacterCheck extends Stage {
    public InvalidCharacterCheck(Card card) {
        super(card);
    }

    @Override
    public void process() throws IOException {
        if(this.card.isValid()){
            String cardNumber = this.card.getNumber();
            for(int i = 0; i < cardNumber.length(); i++){
                char current = cardNumber.charAt(i);
                if(current >= '0' && current <= '9') continue;
                this.card.setError("Invalid: non numeric characters");
                this.card.setInvalid();
                break;
            }
        }
        this.next.process();
    }
}
