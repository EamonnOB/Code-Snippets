import java.io.*;
import java.util.*;
public class IrishAndUKCharts
{
  public static void main(String [] args) throws IOException
  {
	File   f1 = new File("UKTop100Singles.txt");  
	File   f2 = new File("IrishTop100Singles.txt");
	File   f3 = new File("IrishNewEntries.txt");
	ArrayList<String> ukNewEntries = new ArrayList<String>();
	ArrayList<String> irishOnlyNewEntries = new ArrayList<String>();
	Scanner in1;
	String fileElements[];  
    String lineFromFile;
    if (f1.exists() && f2.exists())
    {
	  in1 = new Scanner(f1);
	  while (in1.hasNext())
	  {
		lineFromFile = in1.nextLine();
		fileElements = lineFromFile.split(";");
		ukNewEntries.add(fileElements[2]+";"+fileElements[3]);  
      }  
      in1.close();
      in1 = new Scanner(f2);
	  while (in1.hasNext())
	  {
		lineFromFile = in1.nextLine();
		if((lineFromFile.substring(0,1)).equals("*"))
		{
		  fileElements = lineFromFile.split(";");
		  if(!ukNewEntries.contains(fileElements[2]+";"+fileElements[3]))
	        irishOnlyNewEntries.add(fileElements[2]+";"+fileElements[3]);	  
	    }  
      }  
      in1.close();
      if (irishOnlyNewEntries.isEmpty())
        System.out.println("No entries match this criterion");
      else
      {
	    Collections.sort(irishOnlyNewEntries, Collections.reverseOrder());  
	    System.out.println("Title;Artist");  
	    PrintWriter writer = new PrintWriter(f3);
        for (int i = 0; i < irishOnlyNewEntries.size(); i++)
        {
          System.out.println(irishOnlyNewEntries.get(i));
          writer.println(irishOnlyNewEntries.get(i));
        }
        writer.close();
      }
    }    
    else
      System.out.println("one or both files cannot be located");
  }  	  
} 
