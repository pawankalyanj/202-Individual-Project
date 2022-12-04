package File;

import card.Card;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JsonFileParser extends FileParser{
    public JsonFileParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void readFile(String path) throws IOException, ParseException {
        JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader(this.inPath));
        JSONArray cardsArray = (JSONArray) obj.get("cards");
        for (Object o : cardsArray) {
            JSONObject card = (JSONObject) o;
            cards.add((String) card.get("cardNumber"));
        }
    }

    @Override
    public void writeFile(String path) throws IOException {
        JsonArrayBuilder cardsArray = Json.createArrayBuilder();
        for(String cardNumber: cards){
            Card card = cardMap.get(cardNumber);
            JsonObjectBuilder cardObj = Json.createObjectBuilder();
            if(card.getNumber() == null) cardObj.add("cardNumber", JsonValue.NULL);
            else cardObj.add("cardNumber", Json.createValue(card.getNumber()));
            cardObj.add("cardType", Json.createValue(card.getValue()));
            cardsArray.add(cardObj);
        }
        JsonObjectBuilder cardsObj = Json.createObjectBuilder();
        cardsObj.add("cards", cardsArray);

        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, true);
        FileWriter writer = new FileWriter(path);

        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        JsonWriter jsonWriter = writerFactory.createWriter(writer);

        jsonWriter.writeObject(cardsObj.build());
        jsonWriter.close();
    }
}
