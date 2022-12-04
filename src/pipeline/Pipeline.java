package pipeline;

import card.Card;

import java.io.IOException;

public class Pipeline {

    public void process(Card card) throws IOException {
        Stage cardNumberLengthCheck = new CardNumberLengthCheck(card);
        Stage invalidCharacterCheck = new InvalidCharacterCheck(card);
        Stage cardProviderCheck = new CardProviderCheck(card);

        cardNumberLengthCheck.setNext(invalidCharacterCheck);
        invalidCharacterCheck.setNext(cardProviderCheck);

        cardNumberLengthCheck.process();
    }

}
