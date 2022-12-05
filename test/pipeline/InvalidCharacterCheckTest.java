package pipeline;

import card.Card;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InvalidCharacterCheckTest {

    @Test
    void InvalidCharacterCheck() throws IOException {
        String number1 = "909912345510987@";
        Card card1 = new Card(number1);
        Pipeline pipeline = new Pipeline();
        pipeline.process(card1);
        String expected = "Invalid: non numeric characters";
        String actual = String.valueOf(card1.getValue());
        assertEquals(expected, actual);
    }


}