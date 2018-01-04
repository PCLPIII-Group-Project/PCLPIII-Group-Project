package InchiriereMasina;

import java.util.ArrayList;

public final class Administrare extends PublicUI
{

  private static Administrare instance = null;
  private ArrayList<Masina> masini; //XXX:10  
  private ArrayList<Client> clienti; //XXX:10

  private Administrare()
  {
    masini = new ArrayList<>();
    clienti = new ArrayList<>();
  }

  static Administrare getInstance()
  {
    if (instance == null)
    {
      instance = new Administrare();
      instance.load();
      instance.loadClient();
    }

    return instance;
  }

  //masina
  public void adaugaMasina(Masina masina)
  {
    if (masina != null)
    {
      masini.add(masina);
    }
  }

  public void scoateMasina(Masina masina)
  {
    if (masina != null)
    {
      masini.remove(masina);
    }
  }

  public void save()
  {
    Masina.save(masini);
  }

  public void load()
  {
    masini = Masina.load();
  }

  public ArrayList<Masina> getMasini()
  {
    return masini;
  }

  public void setMasini(ArrayList<Masina> masini)
  {
    this.masini = masini;
  }

  //client
  public void adaugaClient(Client client)
  {
    if (client != null)
    {
      clienti.add(client);
    }
  }

  public void scoateClient(Client client)
  {
    if (client != null)
    {
      clienti.remove(client);
    }
  }

  public void saveClient()
  {
    Client.save(clienti);
  }

  public void loadClient()
  {
    clienti = Client.load();
  }

  public void setClienti(ArrayList<Client> clienti)
  {
    this.clienti = clienti;
  }

  public ArrayList<Client> getClienti()
  {
    return clienti;
  }
}
