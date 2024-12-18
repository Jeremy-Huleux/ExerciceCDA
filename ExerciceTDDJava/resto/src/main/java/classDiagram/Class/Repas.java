package classDiagram.Class;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Repas {
    private LocalDateTime heureDeDebut;
    private LocalDateTime hereDeFin;
    private Client payeur;
    private Serveur serveurResponsable;
    private ArrayList<Plat> plats;
    private Table table;

    public Repas(LocalDateTime heureDeDebut, LocalDateTime hereDeFin) {
        this.heureDeDebut = heureDeDebut;
        this.hereDeFin = hereDeFin;
    }

    public LocalDateTime getHeureDeDebut() {
        return heureDeDebut;
    }

    public void setHeureDeDebut(LocalDateTime heureDeDebut) {
        this.heureDeDebut = heureDeDebut;
    }

    public LocalDateTime getHereDeFin() {
        return hereDeFin;
    }

    public void setHereDeFin(LocalDateTime hereDeFin) {
        this.hereDeFin = hereDeFin;
    }

    public Client getPayeur() {
        return payeur;
    }

    public void setPayeur(Client payeur) {
        this.payeur = payeur;
    }

    public Serveur getServeurResponsable() {
        return serveurResponsable;
    }

    public void setServeurResponsable(Serveur serveurResponsable) {
        this.serveurResponsable = serveurResponsable;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void setPlats(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
