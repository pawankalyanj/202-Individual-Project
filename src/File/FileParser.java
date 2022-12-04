package File;

import card.Card;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import pipeline.Pipeline;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FileParser {
    public Map<String, Card> cardMap;
    public List<String> cards;
    public String inPath, outPath;

    public FileParser(String inPath, String outPath){
        this.inPath = inPath;
        this.outPath = outPath;
        cards = new ArrayList<>();
        cardMap = new HashMap<>();
    }

    public abstract void readFile(String path) throws IOException, ParseException, ParserConfigurationException, SAXException;
    public abstract void writeFile(String path) throws IOException, TransformerException, ParserConfigurationException;

    public void process() throws IOException, ParseException, ParserConfigurationException, SAXException, TransformerException {
        readFile(inPath);
        validateCards();
        writeFile(outPath);
    }

    public void validateCards() throws IOException {
        for(String card: cards){
            Card newCard = new Card(card);
            Pipeline pipeline = new Pipeline();
            pipeline.process(newCard);
            cardMap.put(card, newCard);
        }
    }
}
