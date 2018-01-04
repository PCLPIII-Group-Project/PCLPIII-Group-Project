package InchiriereMasina.SettariDeInterfataGrafica;

import InchiriereMasina.LogThread;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SetariTabel implements SetariGeneral
{

  private static final String FILE_NAME = "setariTabel.txt";
  public static final String TABLE_BKG = "tableBackground";

  private TreeSet<Proprietate> proprietati;
  private boolean defaultSettings;

  public SetariTabel()
  {
    proprietati = new TreeSet<>();
    defaultSettings = false;
  }

  public void load()
  {
    try
    {
      Scanner sc = new Scanner(new File(FILE_NAME)); //XXX:1

      while (sc.hasNext())
      {
        proprietati.add(new Proprietate(sc.next(), new Color(sc.nextInt())));
      }

      sc.close();
    }
    catch (FileNotFoundException ex)
    {
      LogThread log = new LogThread();
      log.addLog("Citirea din fisierul: " + FILE_NAME + " a esuat");
      log.start();

      setDefault();
    }
    catch (Exception ex) //fisierul contine date invalide
    {
      LogThread log = new LogThread();
      log.addLog("Fisierul " + FILE_NAME + " contine date invalide");
      log.start();

      setDefault();
    }

    if (proprietati.isEmpty()) //daca fisierul nu contine date
    {
      setDefault();
    }
  }

  //adauga proprietatea daca nu exista, suprascrie in caz contrar
  public void adaugaProprietate(String cheie, Color valoare)
  {
    Proprietate temp = new Proprietate(cheie, valoare);
    if (proprietati.contains(temp))
    {
      proprietati.remove(temp);
    }
    proprietati.add(new Proprietate(cheie, valoare));
  }

  public void save()
  {
    if (defaultSettings)
    {
      return;
    }

    FileWriter fw;

    try
    {
      fw = new FileWriter(new File(FILE_NAME)); //XXX:2

      Iterator<Proprietate> it = proprietati.iterator();

      Proprietate temp;
      while (it.hasNext())
      {
        temp = it.next();
        fw.write(temp.getCheie() + " " + temp.getValoare().getRGB() + "\r\n");
      }

      fw.flush();
      fw.close();
    }
    catch (IOException ex)
    {
      LogThread log = new LogThread();
      log.addLog("Scrierea in fisierul: " + FILE_NAME + " a esuat");
      log.start();

      setDefault();
    }
  }

  @Override
  public Color cautaProprietatea(String prop)
  {
    Iterator<Proprietate> it = proprietati.iterator();

    Proprietate temp;
    while (it.hasNext())
    {
      temp = it.next();
      if (temp.getCheie().equals(prop))
      {
        return temp.getValoare();
      }
    }

    return null; //nu a fost gasit valoarea cautata
  }

  public void setDefault()
  {
    proprietati = new TreeSet<>();
    proprietati.add(new Proprietate(TABLE_BKG, Color.LIGHT_GRAY));
    defaultSettings = true;
  }

}
