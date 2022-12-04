package File;

import card.Card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

public class XmlFileParser extends FileParser{
    public XmlFileParser(String inPath, String outPath) {
        super(inPath, outPath);
    }

    @Override
    public void readFile(String path) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inPath);
        doc.getDocumentElement().normalize();
        NodeList cardList = doc.getElementsByTagName("CARD");
        for(int i = 0; i < cardList.getLength(); i++){
            Node card = cardList.item(i);
            if(card.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) card;
                cards.add(element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent());
            }
        }
    }

    @Override
    public void writeFile(String path) throws IOException, TransformerException, ParserConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.newDocument();
        Element rootElement = doc.createElement("CARDS");
        doc.appendChild(rootElement);

        for(String cardNumber: cards){
            Card card = cardMap.get(cardNumber);
            Element cardElement = doc.createElement("CARD");
            rootElement.appendChild(cardElement);

            Element cardNumberElement = doc.createElement("CARD_NUMBER");
            cardNumberElement.setTextContent(card.getNumber());
            cardElement.appendChild(cardNumberElement);

            Element cartTypeElement = doc.createElement("CARD_TYPE");
            cartTypeElement.setTextContent(card.getValue());
            cardElement.appendChild(cartTypeElement);
        }

        DOMSource source = new DOMSource(doc);
        FileWriter writer = new FileWriter(outPath);
        StreamResult result = new StreamResult(writer);

        transformer.transform(source, result);

    }
}
