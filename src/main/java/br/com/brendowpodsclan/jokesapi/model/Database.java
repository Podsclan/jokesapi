package br.com.brendowpodsclan.jokesapi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/LIBRARYJOKES";

    public Connection getConnection(){

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, "", "");

        } catch (ClassNotFoundException e) {
            System.out.println("Error on database, class not found: " + e);
        } catch (SQLException ex) {
            System.out.println("Error on database, Sql exception: " + ex);
        }
        return null;
    }

}
