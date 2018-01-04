package InchiriereMasina.SettariDeInterfataGrafica;

import java.awt.Color;

public class Proprietate implements Comparable<Proprietate>
{

  private String cheie;
  private Color valoare;

  Proprietate(String cheie, Color valoare)
  {
    this.cheie = cheie;
    this.valoare = valoare;
  }

  public String getCheie()
  {
    return cheie;
  }

  public void setCheie(String cheie)
  {
    this.cheie = cheie;
  }

  public Color getValoare()
  {
    return valoare;
  }

  public void setValoare(Color valoare)
  {
    this.valoare = valoare;
  }

  @Override
  public int compareTo(Proprietate o)
  {
    return o.getCheie().compareTo(cheie);
  }

}
