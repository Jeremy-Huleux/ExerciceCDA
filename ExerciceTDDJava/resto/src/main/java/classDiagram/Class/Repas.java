package classDiagram.Class;


import java.time.LocalDateTime;

public class Repas {
    private LocalDateTime heureDeDebut;
    private LocalDateTime hereDeFin;

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
}
