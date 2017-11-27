package InchiriereMasina;

import java.util.ArrayList;

public class Administrare
{
  private ArrayList<Masina> masini;
  
  public Administrare()
  {
    masini = new ArrayList<Masina>();
  }
  
  public Administrare( ArrayList<Masina> masini )
  {
    this.masini = masini; 
  }
  
  public void adaugaMasina( Masina masina )
  {
    masini.add(masina);
  }
  
  public void scoateMasina( Masina masina )
  {
    masini.remove(masina);
  }

  public void save()
  {
    Masina.save( masini );
  }
  
  public void load()
  {
    masini = Masina.load();
  }
  
  public ArrayList<Masina> getMasini()
  {
    return masini;
  }

  public void setMasini(ArrayList<Masina> masini)
  {
    this.masini = masini;
  } 
}
