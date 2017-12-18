package InchiriereMasina;

import java.util.ArrayList;

public final class Administrare extends PublicUI
{

  static Administrare instance = null;
  private ArrayList<Masina> masini;

  private Administrare()
  {
    masini = new ArrayList<Masina>();
  }

  static Administrare getInstance()
  {
    if (instance == null)
    {
      instance = new Administrare();
      instance.load();
    }

    return instance;
  }

//  public Administrare(ArrayList<Masina> masini)
//  {
//    this.masini = masini;
//  }
  public void adaugaMasina(Masina masina)
  {
    masini.add(masina);
  }

  public void scoateMasina(Masina masina)
  {
    masini.remove(masina);
  }

  public void save()
  {
    Masina.save(masini);
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
