package org.example.rh.demo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return "";
    }

    @Override
    public List<String> trouverTousLesServices() {
        return List.of();
    }
}
