package org.example.rh.demo.DAO;

import org.example.rh.demo.Model.Employe;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOImpl implements EmployeDAO{
    private Connection connection;

    public EmployeDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void ajouterEmploye(Employe employe) {
        String sql = "INSERT INTO employe (nomEmploye, prenomEmploye, posteEmploye, dateEmbauche, salaire) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, employe.getNom());
            statement.setString(2, employe.getPrenom());
            statement.setString(3, employe.getPoste());
            statement.setDate(4, Date.valueOf(employe.getDateEmbauche()));
            statement.setInt(5, employe.getSalaire());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerEmploye(long id) {
        String sql = "DELETE FROM employe WHERE idEmploye = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifierEmploye(Employe employe) {
        String sql = "UPDATE employe SET" +
                " nomEmploye = ? ," +
                " prenomEmploye = ?," +
                " posteEmploye = ?," +
                " dateEmbauche = ?," +
                " salaire = ?, " +
                "idService = ? " +
                "WHERE idEmploye = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, employe.getNom());
            statement.setString(2, employe.getPrenom());
            statement.setString(3, employe.getPoste());
            statement.setDate(4, Date.valueOf(employe.getDateEmbauche()));
            statement.setInt(5, employe.getSalaire());
            statement.setLong(6, employe.getServiceId());
            statement.setLong(7, employe.getId());
            System.out.println(statement);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employe trouverEmployeeParId(long id) {
        String sql = "SELECT " +
                "e.idEmploye, " +
                "e.nomEmploye, " +
                "e.prenomEmploye, " +
                "e.dateEmbauche, " +
                "e.posteEmploye, " +
                "e.salaire, " +
                "e.idService" +
                "FROM employe e " +
                "WHERE e.idEmploye = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return new Employe(
                        result.getLong("idEmploye"),
                        result.getString("nomEmploye"),
                        result.getString("prenomEmploye"),
                        result.getDate("dateEmbauche").toLocalDate(),
                        result.getString("posteEmploye"),
                        result.getInt("salaire"),
                        result.getLong("idService")
                );
            }
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employe> trouverTousLesEmployes() {
        String sql = "SELECT " +
                "idEmploye, " +
                "nomEmploye, " +
                "prenomEmploye, " +
                "dateEmbauche, " +
                "posteEmploye, " +
                "salaire, " +
                "idService " +
                "FROM employe ";
        System.out.println(sql);
        ArrayList<Employe> emps = new ArrayList<>();
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            try(ResultSet result = pstmt.executeQuery()){
                while(result.next()){
                    Employe emp = new Employe(
                            result.getLong("idEmploye"),
                            result.getString("nomEmploye"),
                            result.getString("prenomEmploye"),
                            result.getDate("dateEmbauche").toLocalDate(),
                            result.getString("posteEmploye"),
                            result.getInt("salaire"),
                            result.getLong("idService")
                    );
                    emps.add(emp);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return emps;
    }
}
