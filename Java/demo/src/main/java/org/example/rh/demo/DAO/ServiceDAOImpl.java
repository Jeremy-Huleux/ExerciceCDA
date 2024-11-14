package org.example.rh.demo.DAO;

import org.example.rh.demo.Model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO{
    private Connection connection;

    public ServiceDAOImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public void ajouterService(String service) {
        String sql = "INSERT INTO service (nomService) WHERE (?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, service);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerService(long id) {
        String sql = "DELETE FROM service WHERE serviceId = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifierService(String service) {

    }

    @Override
    public String trouverServiceParId(long id) {
        String sql = "SELECT nomService, idService FROM service WHERE idService = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                new Service(
                        result.getString("nomService"),
                        result.getLong("idService")
                );
                return  result.getString("nomService");//TODO : Attention ici !
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Service> trouverTousLesServices() {
        ArrayList<Service> listServices = new ArrayList<Service>();
        String sql = "SELECT nomService, idService FROM service";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet result = statement.executeQuery();
            while(result.next()){
                listServices.add(
                    new Service(
                        result.getString("nomService"),
                        result.getLong("idService")
                    )
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listServices;
    }
}
