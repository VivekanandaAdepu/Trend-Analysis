import java.util.*;
import java.io.*;

public class Relevant 
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter frequent set: ");
String filename = keyboard.nextLine();
File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

Scanner keyboard1 = new Scanner(System.in);
System.out.print("Enter Actual feature set: ");
String filename1 = keyboard1.nextLine();
File file2 = new File(filename1);
Scanner inputFile1 = new Scanner(file2);

int i=0,n,k,j=0;
String[] arr = new String[10000];
String[] arr1 = new String[10000];
String[] arr2 = new String[10000];

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

while (inputFile1.hasNext())
{
String line1 = inputFile1.nextLine(); 
line1 = line1.trim();  
for (String retval1: line1.split(" "))
{

arr1[j]=retval1;
//System.out.println(arr1[j]);
j++;
}
}
System.out.println("Array Size:"+j);
k=j;

int x;

for(i=0;i<n;i++)
{
x=0;
if(arr[i].equals("."))
	{
	x=1;
	}

for(j=0;j<k;j++)
{
if(arr[i].equals(arr1[j]))
{
x++;
}
}
if(x==0)
{
arr[i]=" ";
}
}


try 
{
File file = new File("Relevant.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
int l=1;
bw.write("1 ");
for(i=0;i<n;i++)
{
if(!(arr[i].equals(" ")))
{
bw.write(arr[i]);
bw.write(" ");
if(arr[i].equals("."))
{
l++;
String newLine = System.getProperty("line.separator");
bw.write(newLine+l+" ");
}
}
}

bw.close();
} 
catch (IOException e) 
{
e.printStackTrace();
}
System.out.println("Relevant Nouns are Generated and stored in Relevant.txt"); inputFile.close();
}
}