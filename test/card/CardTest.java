package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void Card() {
        String number1 = "ABCD091299012342";
        Card card1 = new Card(number1);
        String expected = "true";
        String actual = String.valueOf(card1.isValid());
        assertEquals(expected, actual);

    }

}