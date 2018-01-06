package InchiriereMasina.InterfataGrafica;

import InchiriereMasina.SettariDeInterfataGrafica.SetariTabel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelFrame extends JFrame //XXX:7
{

  private SetariTabel setari;

  public TabelFrame(String nume, Object[] columnNames, Object[][] rowData)
  {
    super(nume);

    JTable table = new JTable(rowData, columnNames);
    table.setBounds(30, 40, 200, 300); //repozitioneaza si redimensionaza tabelul

    setari = new SetariTabel();
    setari.load();

    Color color;
    if ((color = setari.cautaProprietatea(SetariTabel.TABLE_BKG)) != null)
    {
      table.setBackground(color);
    }

    JScrollPane scrollPane = new JScrollPane(table);

    super.add(scrollPane);
    super.pack();
  }

  @Override
  public void toFront()
  {
    super.setAlwaysOnTop(true);
    super.toFront();
    super.requestFocus();
    super.repaint();
    super.setAlwaysOnTop(false);
  }
}
