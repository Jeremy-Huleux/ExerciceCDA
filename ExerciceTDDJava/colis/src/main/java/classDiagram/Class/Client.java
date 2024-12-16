package classDiagram.Class;

public class Client {
    private long numeroTVA;
    private String nom;
    private int tel;
    private String adresse;

    public Client(long numeroTVA, String nom, int tel, String adresse) {
        this.numeroTVA = numeroTVA;
        this.nom = nom;
        this.tel = tel;
        this.adresse = adresse;
    }

    private void connection(){

    }

    public int selectionneClient(Client receveur, int poids, Type typeLivraison){
        return 0;
    }

}
