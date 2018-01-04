package InchiriereMasina;

import InchiriereMasina.SettariDeInterfataGrafica.SetariAdaugareMasina;
import java.awt.Color;

public class Demo
{

  public static void main(String[] str)
  {
    SetariAdaugareMasina setari = new SetariAdaugareMasina();
    setari.load();
    setari.adaugaProprietate(SetariAdaugareMasina.SAVE_BUTTON_BKG, Color.CYAN);
    setari.adaugaProprietate(SetariAdaugareMasina.CANCEL_BUTTON_BKG, Color.ORANGE);
    setari.save();
  }
}
