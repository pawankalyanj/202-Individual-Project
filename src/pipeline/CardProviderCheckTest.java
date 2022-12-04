package pipeline;


import org.junit.jupiter.api.Test;
import card.Card;

import java.io.IOException;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CardProviderCheckTest {
    @Test
    void CardProviderCheck() throws IOException {
        String number1 = "4132098122341209";
        String number2 = "0911901244576187";
        Card card1 = new Card(number1);
        Card card2 = new Card(number2);
        Pipeline pipeline = new Pipeline();
        pipeline.process(card1);
        pipeline.process(card2);
        String expected1 = "Visa";
        String expected2 = "Invalid: not a possible card number";
        String actual1 = card1.getValue();
        String actual2 = card2.getValue();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

}