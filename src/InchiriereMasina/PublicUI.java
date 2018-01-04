package InchiriereMasina;

import ThirdParty.com.github.mrebhan.crogamp.cli.TableList;

public class PublicUI
{

  public static void listeaza(Administrare adm)
  {
    TableList tl = new TableList(15, "Nr.", "Marca", "Model", "Combustibil", "Anul de fabricare",
      "Pret/Zi", "Cutie de viteza automata", "Data de preluare", "Data de returnare", "Kilometraj",
      "Capacitate cilindrica", "Numar de locuri", "Numar de usi",
      "Norma de poluare", "Culoare");

    System.out.println();

    int i = 1;
    for (Masina m : adm.getMasini())
    {
      tl.addRow(new Integer(i).toString(), m.getMarca(), m.getModel(), m.getCombustibil(),
        new Integer(m.getAnulDeFabricare()).toString(), new Double(m.getPretPeZi()).toString(),
        (m.getCutieDeVitezaAutomata() ? "da" : "nu"), m.getPreluare().toString(),
        m.getReturnare().toString(), new Double(m.getKilometraj()).toString(),
        new Double(m.getCapacitateCilindrica()).toString(),
        new Integer(m.getNumarDeLocuri()).toString(), new Integer(m.getNumarDeUsi()).toString(),
        m.getNormaDePoluare(), m.getCuloare());
      i++;
    }

    tl.print();
  }

  //TODO: implement filtering
}
