import java.io.*;

public class POSTAG 
{
public static void main(String[] args) throws Exception 
{
ProcessBuilder builder = new ProcessBuilder(
 "cmd.exe", "/c", "cd \"C:\\Users\\adminn\\Desktop\\main project_\\3.Pos_tag\" && java -mx500m -classpath stanford-postagger.jar edu.stanford.nlp.tagger.maxent.MaxentTagger -model english-bidirectional-distsim.tagger -textFile output.txt > outfile.txt");
builder.redirectErrorStream(true);
Process p = builder.start();
BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while (true) 
{
line = r.readLine();
if (line == null) 
{
break; 
}
System.out.println(line);
}
}
}