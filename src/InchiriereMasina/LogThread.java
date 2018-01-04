package InchiriereMasina;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LogThread extends Thread //XXX:3
{
  private static final String LOG_FILE_NAME = "log.txt";
  private ArrayList<String> messages; //XXX:10
  
  public LogThread()
  {
    super("Log Thread");
    messages = new ArrayList<>();
  }
  
  public void addLog(String message)
  {
    messages.add(timestamp() + " >> " + message);
  }
  
  @Override
  public void run()
  {
    try
    {
      ArrayList<String> content = readContent();
      
      for (int i = 0; i < messages.size(); i++)
      {
        content.add(messages.get(i));
      }
      
      writeContent(content);
    }
    catch (IOException ex)
    {
      System.out.println("A fost o problema cu crearea log-ului");
    }
  }

  private ArrayList<String> readContent() throws FileNotFoundException
  {
    ArrayList<String> temp = new ArrayList<>();

    Scanner sc = new Scanner(new File(LOG_FILE_NAME)); //XXX:1

    while (sc.hasNext())
    {
      temp.add(sc.nextLine());
    }

    sc.close();

    return temp;
  }

  private void writeContent(ArrayList<String> messages) throws IOException
  {
    FileWriter fw = new FileWriter(new File(LOG_FILE_NAME)); //XXX:2
    
    for(String line : messages)
    {
      fw.write(line + "\n");
    }
    
    fw.close();
  }

  private String timestamp()
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.now();
    return formatter.format(dateTime);
  }
  
}
