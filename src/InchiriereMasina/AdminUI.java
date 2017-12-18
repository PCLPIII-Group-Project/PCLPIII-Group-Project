package InchiriereMasina;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminUI extends PublicUI
{

  public static void adauga(Scanner sc, Administrare adm) throws InputMismatchException
  {
    System.out.print("\nMarca: ");
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
    //TODO: add validation ( if != da/nu => throw InputMismatchException ( NON CASE SENSITIVE! ))
    boolean cutieDeVitezaAutomata = Util.convertBoolean(sc.next());

    System.out.print("Data de preluare: (zz/ll/aaaa): ");
    //TODO: add validation format + correct date + cant be a date from the past
    //(if not valid => throw InputMismatchException)
    Data preluare = Data.convert(sc.next());

    System.out.print("Data de returnare: (zz/ll/aaaa): ");
    //TODO: add validation format + correct date + cant be a date from the past
    //(if not valid => throw InputMismatchException)
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

    System.out.print("\n> Salvati datele introduse? (da/nu): ");
    //TODO: add validation ( if not valid => throw InputMismatchException
    if (Util.convertBoolean(sc.next()))
    {
      adm.adaugaMasina(new Masina(marca, model, combustibil, anulDeFabricatie,
        pretPeZi, cutieDeVitezaAutomata, preluare,
        returnare, kilometraj, capacitateCilindrica,
        numarDeLocuri, numarDeUsi, normaDePoluare, culoare));
      adm.save();
    }
  }

  public static void sterge(Administrare adm, Scanner sc) throws InputMismatchException, IndexOutOfBoundsException
  {
    listeaza(adm);
    System.out.println(" " + (adm.getMasini().size() + 1) + "   | Iesire");

    System.out.print("\n> Selectati masina care vreti sa stergeti: ");

    int option = sc.nextInt();

    if (option == adm.getMasini().size() + 1)
    {
      return;
    }

    adm.scoateMasina(adm.getMasini().get(option - 1));
    adm.save();
  }

  static public void listeazaClienti(Administrare adm)
  {
    ArrayList<Client> clienti = adm.getClienti();

    Object[] columnNames =
    {
      "Nume", "Prenume", "Numar de telefon", "Adresa", "CNP"
    };

    Object[][] rowData = new Object[clienti.size()][5];

    for (int i = 0; i < clienti.size(); i++)
    {
      rowData[i][0] = clienti.get(i).getNume();
      rowData[i][1] = clienti.get(i).getPrenume();
      rowData[i][2] = clienti.get(i).getNumarDeTelefon();
      rowData[i][3] = clienti.get(i).getAdresa();
      rowData[i][4] = clienti.get(i).getCNP();
    }

    JTable table = new JTable(rowData, columnNames);
    table.setBounds(30, 40, 200, 300);

    JScrollPane scrollPane = new JScrollPane(table);

    JFrame frame = new JFrame();
    frame.add(scrollPane);
    frame.setSize(1000, 200);
    frame.setVisible(true);
  }
}
