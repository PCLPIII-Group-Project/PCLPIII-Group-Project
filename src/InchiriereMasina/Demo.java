package InchiriereMasina;

import java.util.ArrayList;

public class Demo
{
  public static void main(String[] args)
  {
    Masina m1 = new Masina("Audi", "RS7", "Benzina", 2017, 500.00, false, new Data(27, 11, 2017),
         new Data(1, 1, 2018), 10205.12, 4000, 5, 5, "Euro2", "AlbastruInchis");
    
    Masina m2 = new Masina("Tesla", "Roadster", "Electricitate", 2017, 300.00, true, new Data(26, 11, 2017),
        new Data(1, 2, 2018), 1005.22, 4000, 2, 3, "NuPoluaza", "RosuInchis");
    
    ArrayList<Masina> masini = new ArrayList<Masina>();
    
    masini.add(m1);
    masini.add(m2);
    
    //salvare datelor
    Masina.save(masini);
    
    //stergerea datelor (salvate) din program
    masini = null;
    
    //incarcarea datelor
    masini = Masina.load();
    
    System.out.println( masini );
  }
}
