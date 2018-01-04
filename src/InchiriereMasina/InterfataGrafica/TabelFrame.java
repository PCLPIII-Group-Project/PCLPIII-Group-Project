
package InchiriereMasina.InterfataGrafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelFrame extends JFrame //XXX:7
{
  
  public TabelFrame(String nume, Object[] columnNames, Object[][] rowData)
  {
    super(nume);
    
    JTable table = new JTable(rowData, columnNames); 
    table.setBounds(30, 40, 200, 300); //misca si redimensionaza tabelul
    //table.setBackground(Color.red);
    //table.setFont(new Font("Times New Roman", Font.BOLD, 20));
    
    JScrollPane scrollPane = new JScrollPane(table);
    
    super.add(scrollPane);
    super.pack();
  }
}
