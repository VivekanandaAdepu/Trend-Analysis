import java.util.*;
import java.io.*;

public class Nouns
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a file name: ");
String filename = keyboard.nextLine();

File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

int i=0,n;
String[] arr = new String[10000];

while (inputFile.hasNext())
{
String line = inputFile.nextLine(); 
line = line.trim();  
for (String retval: line.split(" "))
{

arr[i]=retval;
//System.out.println(arr[i]);
i++;
}
}
System.out.println("Array Size:"+i);
n=i;

for(i=0;i<n;i++)
{
if((arr[i].endsWith("_JJ")) || (arr[i].endsWith("_RB")) || (arr[i].endsWith("_JJR")) || (arr[i].endsWith("_VBZ")) || (arr[i].endsWith("_JJS")) || (arr[i].endsWith("_VBG")) || (arr[i].endsWith("_VBD")) || (arr[i].endsWith("_VBP")) || (arr[i].endsWith("_VBN")) || (arr[i].endsWith("_CC")) || (arr[i].endsWith("_LS")) || (arr[i].endsWith("_,")) || (arr[i].endsWith("!_.")) || (arr[i].endsWith("_VB")) || (arr[i].endsWith("_FW")) || (arr[i].endsWith("_IN")) || (arr[i].endsWith("_NNP")) || (arr[i].endsWith("_MD")) )
arr[i]="";
else if(arr[i].endsWith("_."))
arr[i]=".";
else if(arr[i].endsWith("_CD"))
arr[i]=arr[i].replaceFirst("_CD", "");
else if(arr[i].endsWith("_NN"))
arr[i]=arr[i].replaceFirst("_NN", "");
else if(arr[i].endsWith("_NNS"))
arr[i]=arr[i].replaceFirst("_NNS", "");
}   

try 
{
File file = new File("Nouns.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

for(i=0;i<n;i++)
{
if(!(arr[i].equals("")))
{
bw.write(arr[i]);
bw.write(" ");
if(arr[i].equals("."))
{
String newLine = System.getProperty("line.separator");
bw.write(newLine);
}
}
}

bw.close();
} 
catch (IOException e) 
{
e.printStackTrace();
}
inputFile.close();
System.out.println("Nouns.txt Created!!....");

}
}