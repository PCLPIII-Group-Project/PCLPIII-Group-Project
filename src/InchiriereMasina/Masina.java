package InchiriereMasina;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Masina //implements Comparable<Masina>
{
  //constante
  static private final String LOC_FISIER = "masini.txt";
  
  //caracteristicile principale
  
  //TO-DO: adauga ID
  
  private String marca;
  private String model;
  private String combustibil;
  private int anulDeFabricare;
  private double pretPeZi;
  private boolean cutieDeVitezaAutomata;
  private Data preluare;
  private Data returnare;
  
  //caracteristicile secundare
  private double kilometraj;
  private double capacitateCilindrica;
  private int numarDeLocuri;
  private int numarDeUsi;
  private String normaDePoluare;
  private String culoare;
  
  public Masina( String marca, String model, String combustibil, int anulDeFabricare, double pretPeZi,
             boolean cutieDeVitezaAutomata, Data preluare, Data returnare, double kilometraj, double capacitateCilindrica, int numarDeLocuri, 
             int numarDeUsi, String normaDePoluare, String culoare)
  {
    this.marca = marca;
    this.model = model;
    this.combustibil = combustibil;
    this.anulDeFabricare = anulDeFabricare;
    this.pretPeZi = pretPeZi;
    this.cutieDeVitezaAutomata = cutieDeVitezaAutomata;
    this.preluare = preluare;
    this.returnare = returnare;
    this.kilometraj = kilometraj;
    this.capacitateCilindrica = capacitateCilindrica;
    this.numarDeLocuri = numarDeLocuri;
    this.numarDeUsi = numarDeUsi;
    this.normaDePoluare = normaDePoluare;
    this.culoare = culoare;
  }
  
  public Masina()
  {
    this("", "", "", 0, .0, false, new Data(0,0,0), new Data(0,0,0), .0, .0, 0, 0, "", "");
  }
    
  //salvare
  static void save(ArrayList<Masina> masini) //TODO: change file type to csv
  {
    if (masini == null || masini.size() == 0)
    {
      return;
    }
    
    try
    {
      FileWriter fw = new FileWriter( new File(LOC_FISIER) );
      
      for (int i = 0; i < masini.size(); i++)
      {
        fw.write(masini.get(i).marca + " ");
        fw.write(masini.get(i).model + " ");
        fw.write(masini.get(i).combustibil + " ");
        fw.write(masini.get(i).anulDeFabricare + " ");
        fw.write(masini.get(i).pretPeZi + " ");
        fw.write(masini.get(i).cutieDeVitezaAutomata + " ");
        fw.write(masini.get(i).preluare + " ");
        fw.write(masini.get(i).returnare + " ");
        fw.write(masini.get(i).kilometraj + " ");
        fw.write(masini.get(i).capacitateCilindrica + " ");
        fw.write(masini.get(i).numarDeLocuri + " ");
        fw.write(masini.get(i).numarDeUsi + " ");
        fw.write(masini.get(i).normaDePoluare + " ");
        fw.write(masini.get(i).culoare + " \r\n");
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
  static ArrayList<Masina> load()
  {
    ArrayList<Masina> masini = new ArrayList<Masina>();
    
    try 
    {
      Scanner sc = new Scanner( new File(LOC_FISIER));
    
      while ( sc.hasNext() )
      {
        String marcaMasina = sc.next();
        String modelMasina = sc.next();
        String combustibilMasina = sc.next();
        int anulDeFabricareMasina = sc.nextInt();
        double pretPeZiMasina = sc.nextDouble();
        boolean cutieDeVitezaAutomataMasina = sc.nextBoolean();
        
        Data preluareMasina = Data.convert( sc.next() );
        Data returnareMasina = Data.convert( sc.next() );
        
        double kilometrajMasina = sc.nextDouble();
        double capacitateCilindricaMasina = sc.nextDouble();
        int numarDeLocuriMasina = sc.nextInt();
        int numarDeUsiMasina = sc.nextInt();
        String normaDePoluareMasina = sc.next();
        String culoareMasina = sc.next();
        
        masini.add( new Masina( marcaMasina, modelMasina, combustibilMasina, anulDeFabricareMasina, 
            pretPeZiMasina, cutieDeVitezaAutomataMasina, preluareMasina, returnareMasina, 
            kilometrajMasina, capacitateCilindricaMasina, numarDeLocuriMasina, numarDeUsiMasina, 
            normaDePoluareMasina, culoareMasina ) );
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
    
    return masini;
  }

  @Override
  public String toString()
  {
    return marca + " " + model + " " + combustibil + " " + anulDeFabricare + " " + pretPeZi 
        + " " + cutieDeVitezaAutomata + " " + preluare + " " + returnare + " " + kilometraj 
        + " " + capacitateCilindrica + " " + numarDeLocuri + " " + numarDeUsi + " " + normaDePoluare 
        + " " + culoare;
  }
  
  /*public int compareTo(Masina m)
  {
    if (marca == m.getMarca())
    {
      if (model == m.getModel())
      {
        if (combustibil = m.get)
        {
        }  
      }
    }
    else
    {
      if (marca > m.getMarca() )
      {
        return 1;
      }
      else
      {
        return -1;      
      }
      
    }
  }*/
  
  //setteri si getteri
  public String getMarca()
  {
    return marca;
  }

  public void setMarca(String marca)
  {
    this.marca = marca;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String getCombustibil()
  {
    return combustibil;
  }

  public void setCombustibil(String combustibil)
  {
    this.combustibil = combustibil;
  }

  public int getAnulDeFabricare()
  {
    return anulDeFabricare;
  }

  public void setAnulDeFabricare(int anulDeFabricare)
  {
    this.anulDeFabricare = anulDeFabricare;
  }

  public double getPretPeZi()
  {
    return pretPeZi;
  }

  public void setPretPeZi(double pretPeZi)
  {
    this.pretPeZi = pretPeZi;
  }

  public boolean getCutieDeVitezaAutomata()
  {
    return cutieDeVitezaAutomata;
  }

  public void setCutieDeVitezaAutomata(boolean cutieDeVitezaAutomata)
  {
    this.cutieDeVitezaAutomata = cutieDeVitezaAutomata;
  }

  public Data getPreluare()
  {
    return preluare;
  }

  public void setPreluare(Data preluare)
  {
    this.preluare = preluare;
  }

  public Data getReturnare()
  {
    return returnare;
  }

  public void setReturnare(Data returnare)
  {
    this.returnare = returnare;
  }

  public double getKilometraj()
  {
    return kilometraj;
  }

  public void setKilometraj(double kilometraj)
  {
    this.kilometraj = kilometraj;
  }

  public double getCapacitateCilindrica()
  {
    return capacitateCilindrica;
  }

  public void setCapacitateCilindrica(double capacitateCilindrica)
  {
    this.capacitateCilindrica = capacitateCilindrica;
  }

  public int getNumarDeLocuri()
  {
    return numarDeLocuri;
  }

  public void setNumarDeLocuri(int numarDeLocuri)
  {
    this.numarDeLocuri = numarDeLocuri;
  }

  public int getNumarDeUsi()
  {
    return numarDeUsi;
  }

  public void setNumarDeUsi(int numarDeUsi)
  {
    this.numarDeUsi = numarDeUsi;
  }

  public String getNormaDePoluare()
  {
    return normaDePoluare;
  }

  public void setNormaDePoluare(String normaDePoluare)
  {
    this.normaDePoluare = normaDePoluare;
  }

  public String getCuloare()
  {
    return culoare;
  }

  public void setCuloare(String culoare)
  {
    this.culoare = culoare;
  }
  
 
}
