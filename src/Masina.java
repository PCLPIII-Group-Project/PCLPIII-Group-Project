
public class Masina
{
  //caracteristicile principale
  String marca;
  String model;
  String combustibil;
  String anulDeFabricare;
  double pretPeZi;
  boolean cutieDeVitezaAutomata;
  Data preluare;
  Data returnare;
  
  //caracteristicile secundare
  double kilometraj;
  double capacitateCilindrica;
  int numarDeLocuri;
  int numarDeUsi;
  String normaDePoluare;
  String culoare;
  
  
  Masina( String marca, String model, String combustibil, String anulDeFabricare, double pretPeZi,
             boolean cutieDeVitezaAutomata, double kilometraj, double capacitateCilindrica, int numarDeLocuri, 
             int numarDeUsi, String normaDePoluare, String culoare)
  {
    this.marca = marca;
    this.model = model;
    this.combustibil = combustibil;
    this.anulDeFabricare = anulDeFabricare;
    this.pretPeZi = pretPeZi;
    this.cutieDeVitezaAutomata = cutieDeVitezaAutomata;
    this.kilometraj = kilometraj;
    this.capacitateCilindrica = capacitateCilindrica;
    this.numarDeLocuri = numarDeLocuri;
    this.numarDeUsi = numarDeUsi;
    this.normaDePoluare = normaDePoluare;
    this.culoare = culoare;
  }
  
  //salvare
  //boolean salveaza()
  //{
    
  //}
  
  //incarcare
  //boolean incarcare()
  //{
    
  //}
  
  //setteri si getteri
  public String getMarca()
  {
    return marca;
  }
  public void setMarca(String marca)
  {
    this.marca = marca;
  }
  public String getModel()
  {
    return model;
  }
  public void setModel(String model)
  {
    this.model = model;
  }
  public String getCombustibil()
  {
    return combustibil;
  }
  public void setCombustibil(String combustibil)
  {
    this.combustibil = combustibil;
  }
  public String getAnulDeFabricare()
  {
    return anulDeFabricare;
  }
  public void setAnulDeFabricare(String anulDeFabricare)
  {
    this.anulDeFabricare = anulDeFabricare;
  }
  public double getPretPeZi()
  {
    return pretPeZi;
  }
  public void setPretPeZi(double pretPeZi)
  {
    this.pretPeZi = pretPeZi;
  }
  public boolean isCutieDeVitezaAutomata()
  {
    return cutieDeVitezaAutomata;
  }
  public void setCutieDeVitezaAutomata(boolean cutieDeVitezaAutomata)
  {
    this.cutieDeVitezaAutomata = cutieDeVitezaAutomata;
  }
  public double getKilometraj()
  {
    return kilometraj;
  }
  public void setKilometraj(double kilometraj)
  {
    this.kilometraj = kilometraj;
  }
  public double getCapacitateCilindrica()
  {
    return capacitateCilindrica;
  }
  public void setCapacitateCilindrica(double capacitateCilindrica)
  {
    this.capacitateCilindrica = capacitateCilindrica;
  }
  public int getNumarDeLocuri()
  {
    return numarDeLocuri;
  }
  public void setNumarDeLocuri(int numarDeLocuri)
  {
    this.numarDeLocuri = numarDeLocuri;
  }
  public int getNumarDeUsi()
  {
    return numarDeUsi;
  }
  public void setNumarDeUsi(int numarDeUsi)
  {
    this.numarDeUsi = numarDeUsi;
  }
  public String getNormaDePoluare()
  {
    return normaDePoluare;
  }
  public void setNormaDePoluare(String normaDePoluare)
  {
    this.normaDePoluare = normaDePoluare;
  }
  public String getCuloare()
  {
    return culoare;
  }
  public void setCuloare(String culoare)
  {
    this.culoare = culoare;
  }
  
  
}
