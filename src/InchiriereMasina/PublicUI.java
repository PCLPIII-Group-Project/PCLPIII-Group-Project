package InchiriereMasina;

import ThirdParty.com.github.mrebhan.crogamp.cli.TableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PublicUI
{

  public static void listeaza(ArrayList<Masina> masini)
  {
    TableList tl = new TableList(15, "Nr.", "Marca", "Model", "Combustibil", "Anul de fabricare",
      "Pret/Zi", "Cutie de viteza automata", "Data de preluare", "Data de returnare", "Kilometraj",
      "Capacitate cilindrica", "Numar de locuri", "Numar de usi",
      "Norma de poluare", "Culoare");

    System.out.println();

    int i = 1;
    for (Masina m : masini)
    {
      tl.addRow(Integer.toString(i), m.getMarca(), m.getModel(), m.getCombustibil(),
        Integer.toString(m.getAnulDeFabricare()), Double.toString(m.getPretPeZi()),
        (m.getCutieDeVitezaAutomata() ? "da" : "nu"), m.getPreluare().toString(),
        m.getReturnare().toString(), Double.toString(m.getKilometraj()),
        Double.toString(m.getCapacitateCilindrica()),
        Integer.toString(m.getNumarDeLocuri()), Integer.toString(m.getNumarDeUsi()),
        m.getNormaDePoluare(), m.getCuloare());
      i++;
    }

    tl.print();
  }

  public static void rearanjare(Administrare adm, Comparator<Masina> comp)
  {
    ArrayList<Masina> copie = new ArrayList<>(adm.getMasini()); //XXX:10
    Collections.sort(copie, comp);
    listeaza(copie);
  }
}
