package pipeline;

import card.Card;

import java.io.IOException;

public abstract class Stage {
    public Stage next;
    public Card card;

    public Stage(Card card){
        this.card = card;
    }

    public void setNext(Stage next){this.next = next;}

    public abstract void process() throws IOException;
}
