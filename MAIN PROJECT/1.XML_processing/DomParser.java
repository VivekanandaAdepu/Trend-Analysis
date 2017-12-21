import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class DomParser 
{
public static void main(String[] args)
{
try 
{	
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter an XML file name: ");
String filename = keyboard.nextLine();

File inputFile = new File(filename);
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(inputFile);
doc.getDocumentElement().normalize();
System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
NodeList nList = doc.getElementsByTagName("phone");
File file = new File("output.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
//int i=0;
for (int temp = 0; temp < nList.getLength(); temp++) 
{
Node nNode = nList.item(temp);
System.out.println("\nCurrent Element :");
System.out.println(nNode.getNodeName());

if (nNode.getNodeType() == Node.ELEMENT_NODE) 
{
Element eElement = (Element) nNode;
NodeList NameList = eElement.getElementsByTagName("feature");
for (int count = 0; count < NameList.getLength(); count++) 
{	 
Node node1 = NameList.item(count);
if (node1.getNodeType() == node1.ELEMENT_NODE) 
{
Element feature = (Element) node1;
System.out.print("Feature name : ");
System.out.println(feature.getTextContent());

bw.write(feature.getTextContent());
bw.write(" ");
//String newLine = System.getProperty("line.separator");
//bw.write(newLine);
//i++;
}
}
}
}
bw.close();
} 

catch (Exception e) 
{
e.printStackTrace();
}

}
}