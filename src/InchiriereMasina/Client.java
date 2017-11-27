package InchiriereMasina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client
{
//constante
  static private final String LOC_FISIER = "clienti.txt";
  
  private String nume;
  private String prenume;
  private String numarDeTelefon;
  private Adresa adresa;
  private String CNP;
  
  public Client( String nume, String prenume, String numarDeTelefon, Adresa adresa, String CNP)
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
    if (clienti == null || clienti.size() == 0)
    {
      return;
    }
    
    try
    {
      FileWriter fw = new FileWriter( new File(LOC_FISIER) );
      
      for (int i = 0; i < clienti.size(); i++)
      {
        fw.write(clienti.get(i).nume + " ");
        fw.write(clienti.get(i).prenume + " ");
        fw.write(clienti.get(i).numarDeTelefon + " ");
        fw.write(clienti.get(i).adresa + " ");
        fw.write(clienti.get(i).CNP + " \r\n");
      }
      
      fw.flush();
      fw.close();
    }
    catch( IOException e )
    {
      e.printStackTrace();
    }
  }
  
  //incarcare
  static ArrayList<Client> load()
  {
    ArrayList<Client> clienti = new ArrayList<Client>();
    
    try 
    {
      Scanner sc = new Scanner( new File(LOC_FISIER));
    
      while ( sc.hasNext() )
      {
        String numeClient = sc.next();
        String prenumeClient = sc.next();
        String numarDeTelefonClient = sc.next();
        Adresa adresaClient = Adresa.convert( sc.next() );
        String CNPClient = sc.next();
        
        clienti.add( new Client( numeClient, prenumeClient, numarDeTelefonClient, adresaClient, CNPClient ) );
      }
      
      sc.close();
    }
    catch( FileNotFoundException e )
    {
      e.printStackTrace();
    }
    catch( InputMismatchException e )
    {
      System.out.println("\n############## ATENTIE!!! ####################################################################");
      System.out.println("La crearea unui obiect masina sirurile de caracter(String) nu au nevoie sa contina spatiu!!!");
      System.out.println("Tot ce e citit din fisier cand apare mesajul asta este incorrect!!!");
      System.out.println("#################################################################################################\n");
    }
    catch( NoSuchElementException e )
    {
      System.out.println("\n############## ATENTIE!!! ####################################################################");
      System.out.println("La crearea unui obiect masina sirurile de caracter(String) nu au nevoie sa contina spatiu!!!");
      System.out.println("Tot ce e citit din fisier cand apare mesajul asta este incorrect!!!");
      System.out.println("##############################################################################################\n");
    }
    
    return clienti;
  }
  
  @Override
  public String toString()
  {
    return nume + " " + prenume + " " + numarDeTelefon + " " + adresa + " " + CNP + " \n";
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
