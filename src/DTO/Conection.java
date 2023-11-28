package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    Connection conn = null;
    private static Conection instance = null;

    public Conection(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded with success!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("The Mysql driver couldn't be loaded!");
        }
    }

    public static Conection getInstance(){
        if (instance == null)
        {
            instance = new Conection();
        }
        return instance;
    }

    public Connection getConnection(){
        try
        {
            if ((conn == null) || (conn.isClosed()))
            {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/acelera_second_semester", "root", "");
                System.out.println("Connected!");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void destroy(){
        try
        {
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}