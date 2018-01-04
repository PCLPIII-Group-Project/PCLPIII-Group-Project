
package InchiriereMasina.InterfataGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DateInvalideDialog extends JDialog implements WindowListener, ActionListener
{
  JLabel label;
  JButton button;
  
  public DateInvalideDialog(JFrame parent)
  {
    super(parent, "Date invalide");
    super.setLayout(new BorderLayout(10, 10));
    
    label = new JLabel("Va rugam corectati datele introduse", SwingConstants.CENTER);
    button = new JButton("OK");
    
    button.addActionListener(this);
    
    super.add(label, BorderLayout.NORTH);
    super.add(button, BorderLayout.SOUTH);
    
    super.setSize(300, 100);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("OK"))
    {
      super.setVisible(false);
      super.dispose();
    }
  }
  
  @Override
  public void windowClosing(WindowEvent e)
  {
    super.setVisible(false);
    super.dispose();
  }
  
  @Override
  public void windowOpened(WindowEvent e)
  {
    //not implemented
  }

  @Override
  public void windowClosed(WindowEvent e)
  {
   //not implemented
  }

  @Override
  public void windowIconified(WindowEvent e)
  {
   //not implemented
  }

  @Override
  public void windowDeiconified(WindowEvent e)
  {
   //not implemented
  }

  @Override
  public void windowActivated(WindowEvent e)
  {
   //not implemented
  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
    //not implemented
  }
}
