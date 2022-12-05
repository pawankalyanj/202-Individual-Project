package pipeline;

import card.Card;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CardProviderCheckTest2 {
    @Test
    void CardProviderCheck() throws IOException{
        String number1 = "9099123455109870";
        Card card1 = new Card(number1);
        Pipeline pipeline = new Pipeline();
        pipeline.process(card1);
        String expected = "Invalid: not a possible card number";
        String actual = String.valueOf(card1.getValue());
        assertEquals(expected, actual);
    }

}