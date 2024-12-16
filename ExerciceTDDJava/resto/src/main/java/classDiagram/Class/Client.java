package classDiagram.Class;

public class Client {
    private long idFiscal;
    private String nom;
    private String adresse;

    public Client(long idFiscal, String nom, String adresse) {
        this.idFiscal = idFiscal;
        this.nom = nom;
        this.adresse = adresse;
    }

    public long getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(long idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
