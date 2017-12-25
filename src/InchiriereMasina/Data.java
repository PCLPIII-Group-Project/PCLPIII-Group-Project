package InchiriereMasina;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data
{

  private static final int[] lunile =
  {
    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  };

  private int an;
  private int luna;
  private int zi;

  public Data(int zi, int luna, int an)
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
  public static Data convert(String dataString) throws InputMismatchException
  {
    //validare de format zz/ll/aaaa
    Pattern pattern = Pattern.compile("^[\\d]{1,2}/[\\d]{1,2}/[\\d]{4}$");
    Matcher matcher = pattern.matcher(dataString);

    if (!matcher.matches())
    {
      throw new InputMismatchException();
    }

    //conversie
    String[] dataStringArray = dataString.split("/");

    int data_zi = Integer.parseInt(dataStringArray[0]);
    int data_luna = Integer.parseInt(dataStringArray[1]);
    int data_an = Integer.parseInt(dataStringArray[2]);

    //validare data
    if (1 <= data_luna && data_luna <= 12)
    {
      if (!(1 <= data_zi && data_zi <= lunile[data_luna - 1]
        + (data_luna == 2 && eAnBisect(data_an) ? 1 : 0)))
      {
        throw new InputMismatchException();
      }
    }
    else
    {
      throw new InputMismatchException();
    }

    return new Data(data_zi, data_luna, data_an);
  }

  private static boolean eAnBisect(int an)
  {
    if (an % 100 != 0)
    {
      if (an % 4 == 0)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    else
    {
      if (an % 400 == 0)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
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
