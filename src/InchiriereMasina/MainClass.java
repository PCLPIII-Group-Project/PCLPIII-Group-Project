package InchiriereMasina;

import InchiriereMasina.Comparatoare.CompAnulDeFabricatie;
import InchiriereMasina.Comparatoare.CompCapacitateCilindrica;
import InchiriereMasina.Comparatoare.CompPret;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainClass
{

  public static void main(String[] args)
  {
    LogThread logStart = new LogThread();
    logStart.addLog("Programul a fost pornit");
    logStart.start();

    try
    {
      Administrare adm = Administrare.getInstance();

      Scanner sc = new Scanner(System.in);

      boolean iesire = false;
      while (!iesire)
      {
        System.out.println("\n[1] Administrare");
        System.out.println("[2] Public");
        System.out.println("[3] Iesire");
        System.out.print("\n> Alegeti o optiune: ");

        int option;

        try
        {
          option = sc.nextInt();
        }
        catch (InputMismatchException e)
        {
          option = -1;
          sc = new Scanner(System.in);
        }

        switch (option)
        {
          case 1:
          {
            administrare(adm, sc);
            break;
          }
          case 2:
          {
            publica(adm, sc);
            break;
          }
          case 3:
          {
            iesire = true;

            LogThread logStop = new LogThread();
            logStop.addLog("Programul a oprit");
            logStop.start();
            logStop.join(); //asteapta pana cand threadul termina scrierea, inainte de inchiderea programului

            System.exit(0);
            break;
          }
          default:
          {
            System.out.println("\n> Optiune invalida");
          }
        }
      }

      sc.close();
    }
    catch (Exception e) //prindem toate exceptiile neprinse (daca e cazul)
    {
      LogThread logUnexpected = new LogThread();
      logUnexpected.addLog("Programul a oprit din cauze neasteptate");
      logUnexpected.start();

      try
      {
        logUnexpected.join();
      }
      catch (InterruptedException ex)
      {

      }

      System.out.println("Oops! Something went wrong. :/");
    }

    System.exit(0);
  }

  public static void administrare(Administrare adm, Scanner sc)
  {
    boolean iesire = false;

    while (!iesire)
    {
      System.out.println("\n\tMeniu:");
      System.out.println("[1] Adauga masina");
      System.out.println("[2] Listeaza masinile");
      System.out.println("[3] Sterge masina");
      System.out.println("[4] Listarea clientiilor");
      System.out.println("[5] Iesire");
      System.out.print("\n> Optiune: ");

      int option;

      try
      {
        option = sc.nextInt();
      }
      catch (InputMismatchException e)
      {
        option = -1;
        sc = new Scanner(System.in);
      }

      switch (option)
      {
        case 1:
        {
          //adauga masina
          boolean isValid = false;

          while (!isValid)
          {
            try
            {
              //AdminUI.adauga(sc, adm);
              AdminUI.adaugaMasinaGUI(adm);
              isValid = true;
            }
            catch (InputMismatchException e)
            {
              System.out.println("\n> Data invalida");

              isValid = false;
              sc = new Scanner(System.in);
            }
          }
          break;
        }
        case 2:
        {
          //listeaza masinile
          AdminUI.listeaza(adm.getMasini());

          System.out.println("\n> Apasati butonul [ENTER] pentru iesire");

          try
          {
            System.in.read(); //asteapta pana apasarea butonului [ENTER]
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }

          break;
        }
        case 3:
        {
          //sterge masina
          boolean isValid = false;

          while (!isValid)
          {
            try
            {
              AdminUI.sterge(adm, sc);
              isValid = true;
            }
            catch (Exception e) //InputMismatchException + IndexOutOfBoundsException
            {
              System.out.println("\n> Data invalida");

              isValid = false;
              sc = new Scanner(System.in);
            }
          }

          break;
        }
        case 4:
        {
          //listarea clientiilor
          AdminUI.listeazaClienti(adm);
          break;
        }
        case 5:
        {
          //iesire
          iesire = true;
          break;
        }
        default:
        {
          //optiune invalida
          System.out.println("\n> Optiune invalida");
        }
      }
    }
  }

  public static void publica(Administrare adm, Scanner sc)
  {
    boolean iesire = false;

    while (!iesire)
    {
      PublicUI.listeaza(adm.getMasini());

      System.out.println("\n[1] Rearanjare lista");
      System.out.println("[2] Iesire");
      System.out.print("\n> Alegeti o optiune: ");

      int option;

      try
      {
        option = sc.nextInt();
      }
      catch (InputMismatchException e)
      {
        option = -1;
        sc = new Scanner(System.in);
      }

      switch (option)
      {
        case 1: //Rearanjare lista
        {
          menuRearanjare(adm, sc);
          break;
        }
        case 2: //iesire
        {
          iesire = true;
          break;
        }
        default:
        {
          System.out.println("\n> Optiune invalida");
        }
      }
    }
  }

  private static void menuRearanjare(Administrare adm, Scanner sc)
  {
    boolean iesire = false;

    while (!iesire)
    {
      System.out.println("\n\tRearanjare:");
      System.out.println("[1] Dupa anul de fabricatie");
      System.out.println("[2] Dupa capacitate cilindrica");
      System.out.println("[3] Dupa pret");
      System.out.println("[4] Iesire");
      System.out.print("\n> Alegeti o optiune: ");

      int option;

      try
      {
        option = sc.nextInt();
      }
      catch (InputMismatchException e)
      {
        option = -1;
        sc = new Scanner(System.in);
      }

      switch (option)
      {
        case 1: //rearanjare dupa anul de fabricatie
        {
          PublicUI.rearanjare(adm, new CompAnulDeFabricatie());

          System.out.println("\n> Apasati butonul [ENTER] pentru iesire");

          try
          {
            System.in.read(); //asteapta pana apasarea butonului [ENTER]
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }

          break;
        }
        case 2: //rearanjare dupa capacitate cilindrica
        {
          PublicUI.rearanjare(adm, new CompCapacitateCilindrica());

          System.out.println("\n> Apasati butonul [ENTER] pentru iesire");

          try
          {
            System.in.read(); //asteapta pana apasarea butonului [ENTER]
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }

          break;
        }
        case 3: //rearanjare dupa pret
        {
          PublicUI.rearanjare(adm, new CompPret());

          System.out.println("\n> Apasati butonul [ENTER] pentru iesire");

          try
          {
            System.in.read(); //asteapta pana apasarea butonului [ENTER]
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }

          break;
        }
        case 4: //iesire
        {
          iesire = true;
          break;
        }
        default:
        {
          System.out.println("\n> Optiune invalida");
        }
      }
    }
  }
}
