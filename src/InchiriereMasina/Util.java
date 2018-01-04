package InchiriereMasina;

import java.util.InputMismatchException;

public class Util
{

  static public boolean convertBoolean(String str) throws InputMismatchException
  {
    str = str.toLowerCase();
    
    if (!validateBoolean(str))
    {
      throw new InputMismatchException();
    }
    
    if (str.compareTo("da") == 0)
    {
      return true;
    }
    return false;
  }

  static public boolean validateBoolean(String str)
  {
    str = str.toLowerCase();
    if (str.compareTo("da") == 0
      || str.compareTo("nu") == 0)
    {
      return true;
    }
    return false;
  }

}
