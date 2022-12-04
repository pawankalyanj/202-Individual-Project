package File;

import card.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileParser extends FileParser{

    public CsvFileParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();
        String line;
        while((line = br.readLine()) != null){
            String[] row = line.split(",");
            cards.add(row[0]);
        }
    }

    @Override
    public void writeFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.append("cardNumber,cardType\n");
        for(String number: cards){
            Card card = cardMap.get(number);
            writer.append(card.getNumber());
            writer.append(",");
            writer.append(card.getValue());
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }
}
