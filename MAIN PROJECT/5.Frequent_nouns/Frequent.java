import java.util.*;
import java.io.*;

public class Frequent
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a file name: ");
String filename = keyboard.nextLine();

File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

int i=0,k,n,j,l=0,m=1;
String[] arr = new String[10000];
String[] arr1 = new String[10000];
int[] count = new int[10000];

while (inputFile.hasNext())
{
String line = inputFile.nextLine(); 
line = line.trim();  
for (String retval: line.split(" "))
{

arr[i]=retval;
arr1[i]=retval;
//System.out.println(arr[i]);
i++;
}
}
System.out.println("Array Size:"+i);
n=k=i;

for(i=0;i<n;i++)
{
l=0;
for(j=0;j<k;j++)
{
if(arr[i].equals(arr1[j]))
{
l++;
}
}
count[i]=l;
}   

try 
{
File file = new File("Frequent.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

bw.write("1");	
for(i=0;i<n;i++)
{
if(!(arr1[i].equals(" ")))
{
if(count[i]>=3)
bw.write(arr1[i]);
bw.write(" ");
if(arr[i].equals("."))
{
m++;
String newLine = System.getProperty("line.separator");
bw.write(newLine+m);
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
System.out.println("Frequent Nouns are Genereated and stored in Frequent.txt!!....");
}
}