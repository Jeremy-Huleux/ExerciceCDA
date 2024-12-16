package classDiagram.Class;

import java.sql.Date;

public class RendezVous {
    private Date date;

    public RendezVous(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
