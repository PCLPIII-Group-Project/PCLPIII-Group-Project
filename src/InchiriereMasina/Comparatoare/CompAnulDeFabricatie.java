package InchiriereMasina.Comparatoare;

import InchiriereMasina.Masina;
import java.util.Comparator;

public class CompAnulDeFabricatie implements Comparator<Masina>
{

  @Override
  public int compare(Masina o1, Masina o2)
  {
    return (new Integer(o1.getAnulDeFabricare()).compareTo(o2.getAnulDeFabricare())) * -1;
  }                         //inmultire cu -1 inseamna ordine inversa, in cazul nostru ordine descrescatoare

}
