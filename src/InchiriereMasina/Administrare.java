package InchiriereMasina;

import java.util.ArrayList;

public final class Administrare extends PublicUI
{

  static Administrare instance = null;
  private ArrayList<Masina> masini;
  private ArrayList<Client> clienti;

  private Administrare()
  {
    masini = new ArrayList<Masina>();
    clienti = new ArrayList<Client>();
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
    masini.add(masina);
  }

  public void scoateMasina(Masina masina)
  {
    masini.remove(masina);
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
    clienti.add(client);
  }

  public void scoateClient(Client client)
  {
    clienti.remove(client);
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
