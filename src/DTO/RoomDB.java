package DTO;

import DAO.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class RoomDB {

    Connection connection = null;
    
    public boolean createRoom(Room newRoom) {
        boolean status = true;


        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to create");
        Statement stmt = null;
        

        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO room (name,type,area,perimeter,tot_lamp_room,tot_tug_room,tot_tue_room, fk_house_id) "
                    + "VALUES('" + newRoom.getName() + "','" 
            		+ newRoom.getType() + "','"
                    + newRoom.getArea() + "','"+ 
                    + newRoom.getPerimeter() + "','"+ 
                    + newRoom.getTotLamp() + "','"+ 
                    + newRoom.getTotTUG() + "','" 
                    + newRoom.getTotTUE() + "','"
                    + newRoom.getFkId()+ "');";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);

            status = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            status = false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
                status = false;
            }
        }

        return status;
    }
    
    public void readRoom(Room newRoom) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected! Generating your report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM room ORDER BY id");

            while (res.next()) {
                newRoom.setName(res.getString("name"));
                newRoom.setType(res.getString("type"));
                newRoom.setArea(res.getFloat("area"));
                newRoom.setPerimeter(res.getFloat("perimeter"));
                newRoom.setTotLamp(res.getInt("tot_lamp_room"));
                newRoom.setTotTUG(res.getInt("tot_tug_room"));
                newRoom.setTotTUE(res.getInt("tot_tue_room"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }

    }
    
    public boolean updateRoom(Room newRoom) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to update!");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE room SET name = '" + newRoom.getName() + "' WHERE id = " + newRoom.getId() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
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
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }
    } 
    
    public boolean deleteRoom(Room newRoom) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Ready to delete");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();

            String sql = "DELETE FROM room WHERE name = '" + newRoom.getName() + "';";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
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
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }
    }
    
    public void reportRoom(Room newRoom, DefaultTableModel modelo, int id_house) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Generating room report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM room WHERE fk_house_id = "+ id_house +" ORDER BY id");

            while (res.next()) {
                newRoom.setName(res.getString("name"));
                newRoom.setType(res.getString("type"));
                newRoom.setArea(res.getFloat("area"));
                newRoom.setPerimeter(res.getFloat("perimeter"));
                newRoom.setTotLamp(res.getInt("tot_lamp_room"));
                newRoom.setTotTUG(res.getInt("tot_tug_room"));
                newRoom.setTotTUE(res.getInt("tot_tue_room"));
                modelo.addRow(new Object[]{newRoom.getName(),
                    newRoom.getType(), newRoom.getArea(), newRoom.getPerimeter(), newRoom.getTotLamp(), newRoom.getTotTUG(), newRoom.getTotTUE()});
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }

    }
    
    public void calculatorTugLampDB(Room newRoom) {
            //Calculate TotLamp and TotTug
            switch (newRoom.getType()) {
                case "1": //Area Seca
                    newRoom.setTotTUG((float) Math.ceil(newRoom.getPerimeter() / 5));
                case "2": //Area Lavavel
                    newRoom.setTotTUG((float) Math.ceil(newRoom.getPerimeter() / 3.5f));
                case "3": //Area de Circulacao
                    newRoom.setTotTUG(1f);
                default: System.out.println("Erro!");
            }
            newRoom.setTotLamp((float) Math.floor((newRoom.getArea() - 6) / 4) + 1);
    }
}
