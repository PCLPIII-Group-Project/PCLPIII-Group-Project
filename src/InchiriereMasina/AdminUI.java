package InchiriereMasina;

import InchiriereMasina.InterfataGrafica.AdaugaMasinaFrame;
import InchiriereMasina.InterfataGrafica.TabelFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminUI extends PublicUI //XXX:4
{

  @Deprecated
  public static void adauga(Scanner sc, Administrare adm) throws InputMismatchException
  {
    sc.nextLine(); //sare pe linia urmatoare, pentru ca in linia respectiva e doar un caracter newline 

    System.out.print("\nMarca: ");
    String marca = sc.nextLine();

    System.out.print("Model: ");
    String model = sc.nextLine();

    System.out.print("Combustibil: ");
    String combustibil = sc.nextLine();

    System.out.print("Anul de fabricatie: ");
    int anulDeFabricatie = sc.nextInt();
    sc.nextLine();

    System.out.print("Pret pe zi: ");
    double pretPeZi = sc.nextDouble();
    sc.nextLine();

    System.out.print("Cutie de viteza automata (da/nu): ");
    boolean cutieDeVitezaAutomata = Util.convertBoolean(sc.nextLine());

    System.out.print("Data de preluare: (zz/ll/aaaa): ");
    Data preluare = Data.convert(sc.nextLine());

    System.out.print("Data de returnare: (zz/ll/aaaa): ");
    Data returnare = Data.convert(sc.nextLine());

    System.out.print("Kilometraj: ");
    double kilometraj = sc.nextDouble();
    sc.nextLine();

    System.out.print("Capacitate Cilindrica: ");
    double capacitateCilindrica = sc.nextDouble();
    sc.nextLine();

    System.out.print("Numar de locuri: ");
    int numarDeLocuri = sc.nextInt();
    sc.nextLine();

    System.out.print("Numar de usi: ");
    int numarDeUsi = sc.nextInt();
    sc.nextLine();

    System.out.print("Norma de poluare: ");
    String normaDePoluare = sc.nextLine();

    System.out.print("Culoare: ");
    String culoare = sc.nextLine();

    System.out.print("\n> Salvati datele introduse? (da/nu): ");
    if (Util.convertBoolean(sc.nextLine()))
    {
      adm.adaugaMasina(new Masina(marca, model, combustibil, anulDeFabricatie,
        pretPeZi, cutieDeVitezaAutomata, preluare,
        returnare, kilometraj, capacitateCilindrica,
        numarDeLocuri, numarDeUsi, normaDePoluare, culoare));
      adm.save();
    }

  }

  public static void adaugaMasinaGUI(Administrare adm)
  {
    AdaugaMasinaFrame frame = new AdaugaMasinaFrame(adm); //XXX:7
    frame.setVisible(true);
  }

  public static void sterge(Administrare adm, Scanner sc) throws InputMismatchException, IndexOutOfBoundsException
  {
    listeaza(adm);
    System.out.println(" " + (adm.getMasini().size() + 1) + "   | Iesire");

    System.out.print("\n> Selectati masina care vreti sa stergeti: ");

    int option = sc.nextInt();

    if (option == adm.getMasini().size() + 1) //cand este ales optiunea "iesire"
    {
      return;
    }

    adm.scoateMasina(adm.getMasini().get(option - 1));
    adm.save();
  }

  static public void listeazaClienti(Administrare adm)
  {
    ArrayList<Client> clienti = adm.getClienti();

    //copie pentru sortare
    ArrayList<Client> copie = new ArrayList<>(clienti); //XXX:10
    Collections.sort(copie); //XXX:9

    Object[] columnNames =
    {
      "Nume", "Prenume", "Numar de telefon", "Adresa", "CNP"
    };

    Object[][] rowData = new Object[clienti.size()][5];

    for (int i = 0; i < copie.size(); i++)
    {
      rowData[i][0] = copie.get(i).getNume();
      rowData[i][1] = copie.get(i).getPrenume();
      rowData[i][2] = copie.get(i).getNumarDeTelefon();
      rowData[i][3] = copie.get(i).getAdresa();
      rowData[i][4] = copie.get(i).getCNP();
    }

    TabelFrame frame = new TabelFrame("Clienti", columnNames, rowData); //XXX:7
    frame.setSize(1000, 200);
    frame.setVisible(true);
  }
}
