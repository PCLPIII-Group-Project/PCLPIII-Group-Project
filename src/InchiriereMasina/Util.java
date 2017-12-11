package InchiriereMasina;

public class Util
{
  static boolean convertBoolean( String str )
  {
    str.toLowerCase();
    if ( str.compareTo( new String("da") ) == 0 )
    {
      return true;
    }
    return false; 
  }
  
  
}
