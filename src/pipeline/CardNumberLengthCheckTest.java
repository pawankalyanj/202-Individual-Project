package pipeline;

import org.junit.jupiter.api.Test;
import card.Card;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CardNumberLengthCheckTest {
    @Test
    void CardNumberLengthCheck() throws IOException {
        String number1 = "0997983998798776888760099898";
        String number2 = "4122091912345678";
        Card card1 = new Card(number1);
        Card card2 = new Card(number2);
        Pipeline pipeline = new Pipeline();
        pipeline.process(card1);
        pipeline.process(card2);
        String expected1 = "false";
        String expected2 = "true";
        String actual1 = String.valueOf(card1.isValid());
        String actual2 = String.valueOf(card2.isValid());
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);


    }

}