package InchiriereMasina;

import java.util.InputMismatchException;
import java.util.Scanner;

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
}
