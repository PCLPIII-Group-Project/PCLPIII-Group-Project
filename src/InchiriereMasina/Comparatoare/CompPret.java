
package InchiriereMasina.Comparatoare;

import InchiriereMasina.Masina;
import java.util.Comparator;

public class CompPret implements Comparator<Masina>
{

  @Override
  public int compare(Masina o1, Masina o2)
  {
    return (new Double(o1.getPretPeZi()).compareTo(o2.getPretPeZi()));
  }
  
}
