package InchiriereMasina.Comparatoare;

import InchiriereMasina.Masina;
import java.util.Comparator;

public class CompCapacitateCilindrica implements Comparator<Masina>
{

  @Override
  public int compare(Masina o1, Masina o2)
  {
    return (new Double(o1.getCapacitateCilindrica()).compareTo(o2.getCapacitateCilindrica())) * -1;
  }                 //inmultire cu -1 inseamna ordine inversa, in cazul nostru ordine descrescatoare

}
