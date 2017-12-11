package InchiriereMasina;

import java.io.IOException;
import java.util.Scanner;
import ThirdParty.com.github.mrebhan.crogamp.cli.TableList;

public class MainClass
{

  public static void main(String[] args)
  {   
    Administrare adm = new Administrare();
    Scanner sc = new Scanner( System.in );
    adm.load();
    
    boolean iesire = false;
    
    while( !iesire )
    {
      System.out.println("\tMeniu:");
      System.out.println("[1] Adauga masina");
      System.out.println("[2] Listeaza masinile");
      System.out.println("[3] Sterge masina");
      System.out.println("[4] Iesire");
      System.out.print("\n> Optiune: ");      
      
      int option = sc.nextInt();
      
      switch( option )
      {
        case 1:
        {
          //adauga masina
          adauga(sc, adm);
          break;
        }
        case 2:
        {
          //listeaza masinile
          listeaza(adm);
          break;
        }
        case 3:
        {
          //sterge masina
          //TODO: implement
          break;
        }
        case 4:
        {
          //iesire
          iesire = true;
          break;
        }
        default:
        {
          //optiune invalida
          System.out.println("\nOptiune invalida!\n");
          
          try
          {
            Thread.sleep(1000);
          }
          catch( InterruptedException e )
          {
            e.printStackTrace();
          }
        }
      }      
    }
    
    sc.close();
  }
  
  private static void adauga( Scanner sc, Administrare adm ) //TODO: data validation!
  { 
    System.out.print("Marca: ");
    String marca = sc.next();
    
    System.out.print("Model: ");
    String model = sc.next();
    
    System.out.print("Combustibil: ");
    String combustibil = sc.next();
    
    System.out.print("Anul de fabricatie: ");
    int anulDeFabricatie = sc.nextInt();
    
    System.out.print("Pret pe zi: ");
    double pretPeZi = sc.nextDouble();
    
    System.out.print("Cutie de viteza automata (da/nu): "); 
    boolean cutieDeVitezaAutomata = Util.convertBoolean( sc.next() );
    
    System.out.print("Data de preluare: (zz/ll/aaaa): ");    
    Data preluare = Data.convert(sc.next());    
    
    System.out.print("Data de returnare: (zz/ll/aaaa): ");
    Data returnare = Data.convert(sc.next());
    
    System.out.print("Kilometraj: ");
    double kilometraj = sc.nextDouble();
    
    System.out.print("Capacitate Cilindrica: ");
    double capacitateCilindrica = sc.nextDouble();
    
    System.out.print("Numar de locuri: ");
    int numarDeLocuri = sc.nextInt();
    
    System.out.print("Numar de usi: ");
    int numarDeUsi = sc.nextInt();
    
    System.out.print("Norma de poluare: ");
    String normaDePoluare = sc.next();
    
    System.out.print("Culoare: ");
    String culoare = sc.next();       
    
    System.out.print( "\n> Salvati datele introduse? (da/nu): " );
    if ( Util.convertBoolean( sc.next() ) )
    {
      adm.adaugaMasina( new Masina( marca, model, combustibil, anulDeFabricatie, 
                                                 pretPeZi, cutieDeVitezaAutomata, preluare, 
                                                 returnare, kilometraj, capacitateCilindrica,
                                                 numarDeLocuri, numarDeUsi, normaDePoluare, culoare ));
      adm.save();
    }
  }
  
  private static void listeaza( Administrare adm )
  {
    TableList tl = new TableList(15, "Nr.", "Marca", "Model", "Combustibil", "Anul de fabricare",
        "Pret/Zi", "Cutie de viteza automata", "Data de preluare", "Data de returnare", "Kilometraj",
        "Capacitate cilindrica", "Numar de locuri", "Numar de usi", 
        "Norma de poluare", "Culoare");
     
    int i = 1;
    for (Masina m : adm.getMasini() )
    {
      tl.addRow( new Integer(i).toString(), m.getMarca(), m.getModel(), m.getCombustibil(), 
          new Integer( m.getAnulDeFabricare() ).toString(), new Double( m.getPretPeZi() ).toString(), 
          ( m.getCutieDeVitezaAutomata() ? "da" : "nu" ), m.getPreluare().toString(),
          m.getReturnare().toString(), new Double( m.getKilometraj() ).toString(), 
          new Double( m.getCapacitateCilindrica() ).toString(),
          new Integer( m.getNumarDeLocuri() ).toString(), new Integer( m.getNumarDeUsi() ).toString(), 
          m.getNormaDePoluare(), m.getCuloare() );
      i++;
    }
    
    tl.print();
    
    System.out.println("\n> Apasati butonul [ENTER] pentru iesire");
    
    try
    {
      System.in.read(); //asteapta pana apasarea butonului [ENTER]
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    } 
  }

}
