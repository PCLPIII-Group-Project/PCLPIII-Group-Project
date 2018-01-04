package InchiriereMasina.InterfataGrafica;

import InchiriereMasina.Administrare;
import InchiriereMasina.Data;
import InchiriereMasina.Masina;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdaugaMasinaFrame extends JFrame implements ActionListener, WindowListener//XXX:7
{
  //TODO: replace adm arguments to getInstance
  private JPanel labels;
  private JPanel fields;
  private JPanel buttons;
  private Administrare adm;

  public AdaugaMasinaFrame(Administrare adm)
  {
    super("Adauga masina");
    super.setLayout(new BorderLayout(10, 10));

    initLabels();
    initFields();
    initButtons();
    
    super.add(labels, BorderLayout.WEST);
    super.add(fields, BorderLayout.EAST);
    super.add(buttons, BorderLayout.SOUTH);

    super.addWindowListener(this);
    
    super.pack();
    
    this.adm = adm;
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Save"))
    {
      Component[] comp = fields.getComponents();

      try
      { //prelucrarea datelor
        String marca = ((JTextField) comp[0]).getText();
        String model = ((JTextField) comp[1]).getText();
        String combustibil = ((JTextField) comp[2]).getText();
        int anulDeFabricatie = Integer.parseInt(((JTextField) comp[3]).getText());
        double pretPeZi = Double.parseDouble(((JTextField) comp[4]).getText());
        boolean cutieVitezaAutomata = ((JCheckBox) comp[5]).isSelected();
        Data preluare = dealWithDatePanel((JPanel) comp[6]);
        Data returnare = dealWithDatePanel((JPanel) comp[7]);
        double kilometraj = Double.parseDouble(((JTextField) comp[8]).getText());
        double capacitateCilindrica = Double.parseDouble(((JTextField) comp[9]).getText());
        int numarDeLocuri = Integer.parseInt(((JTextField) comp[10]).getText());
        int numarDeUsi = Integer.parseInt(((JTextField) comp[11]).getText());
        String normaDePoluare = ((JTextField) comp[12]).getText();
        String culoare = ((JTextField) comp[13]).getText();

        adm.adaugaMasina( new Masina(marca, model, combustibil, anulDeFabricatie, pretPeZi,
          cutieVitezaAutomata, preluare, returnare, kilometraj, capacitateCilindrica,
          numarDeLocuri, numarDeUsi, normaDePoluare, culoare) );
        adm.save();
        
        this.setVisible(false);
        this.dispose();
      }
      catch (Exception ex) //datele introduse sunt invalide
      {
        DateInvalideDialog dialog = new DateInvalideDialog(this);
        dialog.setVisible(true);
      }
    }
    else if (e.getActionCommand().equals("Cancel"))
    {
      this.setVisible(false);
      this.dispose();
    }
  }

  private void initLabels()
  {
    labels = new JPanel();
    labels.setLayout(new GridLayout(14, 1));

    labels.add(new JLabel("Marca"));
    labels.add(new JLabel("Model"));
    labels.add(new JLabel("Combustibil"));
    labels.add(new JLabel("Anul de fabricatie"));
    labels.add(new JLabel("Preti pe zi(Euro)"));
    labels.add(new JLabel("Cutie de viteza automata"));
    labels.add(new JLabel("Data de preluare"));
    labels.add(new JLabel("Data de returnare"));
    labels.add(new JLabel("Kilometraj"));
    labels.add(new JLabel("Capacitate cilindrica"));
    labels.add(new JLabel("Numar de locuri"));
    labels.add(new JLabel("Numar de usi"));
    labels.add(new JLabel("Norma de poluare"));
    labels.add(new JLabel("Culoare"));
  }

  private void initFields()
  {
    fields = new JPanel();
    fields.setLayout(new GridLayout(14, 1));

    fields.add(new JTextField(10)); //Marca
    fields.add(new JTextField(10)); //Model
    fields.add(new JTextField(10)); //Combustibil
    fields.add(new JTextField(10)); //Anul de fabricatie
    fields.add(new JTextField(10)); //Preti pe zi
    fields.add(new JCheckBox()); //Cutie viteza automata
    fields.add(makeDatePanel()); //Data de preluare
    fields.add(makeDatePanel()); //Data de returnare
    fields.add(new JTextField(10)); //Kilometraj
    fields.add(new JTextField(10)); //Capacitate cilindrica
    fields.add(new JTextField(10)); //Numar de locuri
    fields.add(new JTextField(10)); //Numar de usi
    fields.add(new JTextField(10)); //Norma de poluare
    fields.add(new JTextField(10)); //Culoare
  }

  private void initButtons()
  {
    buttons = new JPanel();
    buttons.setLayout(new GridLayout(1, 2, 10, 0));

    JButton save = new JButton("Save");
    save.addActionListener(this);

    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(this);

    buttons.add(save);
    buttons.add(cancel);
  }

  private JPanel makeDatePanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    panel.add(new JTextField(2)); //zi
    panel.add(new JLabel("/"));
    panel.add(new JTextField(2)); //luna
    panel.add(new JLabel("/"));
    panel.add(new JTextField(4)); //an

    return panel;
  }

  private Data dealWithDatePanel(JPanel panel) throws InputMismatchException
  {
    Component[] comp = panel.getComponents();

    String zi = ((JTextField) comp[0]).getText();
    String luna = ((JTextField) comp[2]).getText();
    String an = ((JTextField) comp[4]).getText();

    return Data.convert(zi + "/" + luna + "/" + an);
  }

  @Override
  public void windowOpened(WindowEvent e)
  {
    //not implemented
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    this.setVisible(false);
    this.dispose();
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
