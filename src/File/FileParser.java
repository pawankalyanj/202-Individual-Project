package File;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class FileParser {
    public Map<String, String> cardMap;
    public List<String> cards;
    public String inPath, outPath;

    public FileParser(String inPath, String outPath){
        this.inPath = inPath;
        this.outPath = outPath;
    }

    public abstract void readFile(String path) throws IOException;
    public abstract void writeFile(String path) throws IOException;

    public void process() throws IOException {
        readFile(inPath);
        validateCards();
//        writeFile(outPath);
    }

    public void validateCards(){
        for(String card: cards){
            System.out.println(card);
        }
    }
}
