package DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Login;

    public class LoginDB {

        Connection connection = null;

        public boolean verifyAcess(Login login){

            connection = Conection.getInstance().getConnection();
            System.out.println("Connected and verifyng acess");
            Statement stmt = null;

            boolean status = true;

            try
            {
                stmt = connection.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM users");

                while(res.next())
                {
                    if(login.getName().compareTo(res.getString("name"))==0 && login.getPassword().compareTo(res.getString("password"))==0)
                    {
                        status = true;
                        
                        break;
                    }
                    else
                    {
                        status = false;
                    }

                }

            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
                status = false;
            }
            finally
            {

                try
                {
                    stmt.close();
                    connection.close();
                }
                catch (SQLException e)
                {
                    System.out.println("Fail to disconnect" + e.getMessage());
                }
            }

            return status;
        }
    }

