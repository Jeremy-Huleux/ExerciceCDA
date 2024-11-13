package org.example.rh.demo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/rh";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    //Méthode pour obtenir une connexion
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //Méthode pour fermer la connexion
    public static void clodeConnection(Connection conn){
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
