package InchiriereMasina;

public class Data
{
  private int an;
  private int luna;
  private int zi;
  
  public Data( int zi, int luna, int an)
  {
    this.an = an;
    this.luna = luna;
    this.zi = zi;
  }
  
  public Data()
  {
    this(0, 0, 0);
  }

  @Override
  public String toString()
  {
    return zi + "/" + luna + "/" + an;
  }
  
  //convertor String -> Data
  static Data convert(String dataString)
  {
    String[] dataStringArray = dataString.split("/");
    
    int data_zi = Integer.parseInt(dataStringArray[0]);
    int data_luna = Integer.parseInt(dataStringArray[1]);
    int data_an = Integer.parseInt(dataStringArray[2]);
    
    return new Data( data_zi, data_luna, data_an );
  }
  
  public int getAn()
  {
    return an;
  }

  public void setAn(int an)
  {
    this.an = an;
  }

  public int getLuna()
  {
    return luna;
  }

  public void setLuna(int luna)
  {
    this.luna = luna;
  }

  public int getZi()
  {
    return zi;
  }

  public void setZi(int zi)
  {
    this.zi = zi;
  }
}
