package org.example.rh.demo.Model;

public class Service {
    private String nomService;
    private long idService;

    public Service(String nomService, long idService) {
        this.nomService = nomService;
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return nomService;
    }
}
