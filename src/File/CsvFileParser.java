package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CsvFileParser extends FileParser{

    public CsvFileParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void readFile(String path) throws IOException {
        System.out.println(path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();
        String line;
        cards = new ArrayList<>();
        while((line = br.readLine()) != null){
            String[] row = line.split(",");
            cards.add(row[0]);
        }
    }

    @Override
    public void writeFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.append("cardNumber,cardType");
        for(Map.Entry<String, String> entry: cardMap.entrySet()){
            writer.append(entry.getKey());
            writer.append(",");
            writer.append(entry.getValue());
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }
}
