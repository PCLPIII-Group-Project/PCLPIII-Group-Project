package InchiriereMasina;

public class Adresa
{
  private String strada;
  private int nr;
  private int bl;
  private String sc;
  private int et;
  private int ap;
  private String localitate;
  private String judet;
  
  public Adresa(String strada, int nr, int bl, String sc, 
      int et, int ap, String localitate, String judet)
  {
    this.strada = strada;
    this.nr = nr;
    this.bl = bl;
    this.sc = sc;
    this.et = et;
    this.ap = ap;
    this.localitate = localitate;
    this.judet = judet;
  }

  @Override
  public String toString()
  {
    return strada + "," + nr + "," + bl + "," + sc + "," + et + "," + ap + "," + localitate + "," + judet;
  }

  static public Adresa convert( String adresaString )
  {
    String[] adresaStringArray = adresaString.split(",");
    
    String stradaAdresa = adresaStringArray[0];
    int nrAdresa = Integer.parseInt( adresaStringArray[1] );
    int blAdresa = Integer.parseInt( adresaStringArray[2] );
    String scAdresa = adresaStringArray[3];
    int etAdresa = Integer.parseInt( adresaStringArray[4] );
    int apAdresa = Integer.parseInt( adresaStringArray[5] );
    String localitateAdresa = adresaStringArray[6];
    String judetAdresa = adresaStringArray[7];
    
    return new Adresa(stradaAdresa, nrAdresa, blAdresa, scAdresa, etAdresa, 
               apAdresa, localitateAdresa, judetAdresa);
  }
  
  public String getStrada()
  {
    return strada;
  }

  public void setStrada(String strada)
  {
    this.strada = strada;
  }

  public int getNr()
  {
    return nr;
  }

  public void setNr(int nr)
  {
    this.nr = nr;
  }

  public int getBl()
  {
    return bl;
  }

  public void setBl(int bl)
  {
    this.bl = bl;
  }

  public String getSc()
  {
    return sc;
  }

  public void setSc(String sc)
  {
    this.sc = sc;
  }

  public int getEt()
  {
    return et;
  }

  public void setEt(int et)
  {
    this.et = et;
  }

  public int getAp()
  {
    return ap;
  }

  public void setAp(int ap)
  {
    this.ap = ap;
  }

  public String getLocalitate()
  {
    return localitate;
  }

  public void setLocalitate(String localitate)
  {
    this.localitate = localitate;
  }

  public String getJudet()
  {
    return judet;
  }

  public void setJudet(String judet)
  {
    this.judet = judet;
  }
}
