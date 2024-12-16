package classDiagram.Class;

public class Colis {
    private int poids;
    private Type typeLivraison;
    private int code;
    private CentreLivraison centreEnvoie;
    private CentreLivraison centreReception;

    public Colis(int poids, Type typeLivraison, int code, CentreLivraison centreEnvoie, CentreLivraison centreReception) {
        this.poids = poids;
        this.typeLivraison = typeLivraison;
        this.code = code;
        this.centreEnvoie = centreEnvoie;
        this.centreReception = centreReception;
    }

    private int generationCode(){
        return 0;
    }

    private CentreLivraison selectionCentreReceptionPlusProche(Client clientEnvoie){
        return this.centreReception;
    }
}
