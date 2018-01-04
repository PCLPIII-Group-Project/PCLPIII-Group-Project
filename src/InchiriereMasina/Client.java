package InchiriereMasina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Comparable<Client> //XXX:9
{
//constante

  static private final String LOC_FISIER = "clienti.txt";

  private String nume;
  private String prenume;
  private String numarDeTelefon;
  private Adresa adresa;
  private String CNP;

  public Client(String nume, String prenume, String numarDeTelefon, Adresa adresa, String CNP)
  {
    this.nume = nume;
    this.prenume = prenume;
    this.numarDeTelefon = numarDeTelefon;
    this.adresa = adresa;
    this.CNP = CNP;
  }

//salvare
  static void save(ArrayList<Client> clienti)
  {
    if (clienti == null || clienti.isEmpty())
    {
      return;
    }

    try
    {
      FileWriter fw = new FileWriter(new File(LOC_FISIER)); //XXX:2

      for (int i = 0; i < clienti.size(); i++)
      {
        fw.write(clienti.get(i).nume + ";");
        fw.write(clienti.get(i).prenume + ";");
        fw.write(clienti.get(i).numarDeTelefon + ";");
        fw.write(clienti.get(i).adresa + ";");
        fw.write(clienti.get(i).CNP + "\r\n");
      }

      fw.flush();
      fw.close();
    }
    catch (IOException e)
    {
      LogThread log = new LogThread();
      log.addLog("A fost o problema cu scrierea fisierului clienti.txt");
      log.start();
      
      System.out.println("A fost o problema cu scrierea fisierului clienti.txt");
    }
  }

  //incarcare
  static ArrayList<Client> load()
  {
    ArrayList<Client> clienti = new ArrayList<>();

    try
    {
      Scanner sc = new Scanner(new File(LOC_FISIER));  //XXX:1
      sc.useDelimiter(";");

      while (sc.hasNext())
      {
        String numeClient = sc.next();
        String prenumeClient = sc.next();
        String numarDeTelefonClient = sc.next();
        Adresa adresaClient = Adresa.convert(sc.next());
        String CNPClient = sc.next();

        sc.nextLine();//pentru a sari peste caracterul newline

        clienti.add(new Client(numeClient, prenumeClient, numarDeTelefonClient, adresaClient, CNPClient));
      }

      sc.close();
    }
    catch (FileNotFoundException e)
    {
      LogThread log = new LogThread();  //XXX:3
      log.addLog("Nu a fost gasit fisierul clienti.txt");
      log.start();
      
      System.out.println("Nu a fost gasit fisierul clienti.txt");
    }
    catch (Exception e)
    {
      System.out.println("Fisierul clienti.txt contine date invalide");
    }

    return clienti;
  }

  @Override
  public String toString()
  {
    return nume + " " + prenume + " " + numarDeTelefon + " " + adresa + " " + CNP + " \n";
  }

  @Override
  public int compareTo(Client o)
  {
    int compNume = nume.compareTo(o.getNume());
    
    if (compNume != 0)
    {
      return compNume;
    }
    else
    {
      return prenume.compareTo(o.getPrenume());
    }
  }
  
  //setteri si getteri
  public String getNume()
  {
    return nume;
  }

  public void setNume(String nume)
  {
    this.nume = nume;
  }

  public String getPrenume()
  {
    return prenume;
  }

  public void setPrenume(String prenume)
  {
    this.prenume = prenume;
  }

  public String getNumarDeTelefon()
  {
    return numarDeTelefon;
  }

  public void setNumarDeTelefon(String numarDeTelefon)
  {
    this.numarDeTelefon = numarDeTelefon;
  }

  public Adresa getAdresa()
  {
    return adresa;
  }

  public void setAdresa(Adresa adresa)
  {
    this.adresa = adresa;
  }

  public String getCNP()
  {
    return CNP;
  }

  public void setCNP(String cNP)
  {
    CNP = cNP;
  }
}
