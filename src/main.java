import File.CsvFileParser;
import File.FileParser;
import File.JsonFileParser;
import File.XmlFileParser;

 public class main {
    public static void main(String args[]) throws Exception {
        FileParser csvFile = new CsvFileParser("./SampleInputOutputFiles/input_file.csv", "./SampleInputOutputFiles/output_file.csv");
        FileParser jsonFile = new JsonFileParser("./SampleInputOutputFiles/input_file.json", "./SampleInputOutputFiles/output_file.json");
        FileParser xmlFile = new XmlFileParser("./SampleInputOutputFiles/input_file.xml", "./SampleInputOutputFiles/output_file.xml");

        csvFile.process();
        jsonFile.process();
        xmlFile.process();
    }
}