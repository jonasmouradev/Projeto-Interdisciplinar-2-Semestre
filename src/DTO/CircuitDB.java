package DTO;

import DAO.Circuit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class CircuitDB {
    Connection connection = null;
    
    public boolean createCircuit(Circuit newCircuit) {
        boolean status = true;

        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to create");
        Statement stmt = null;
        

        try {
            stmt = connection.createStatement();

            String sql = "INSERT INTO circuit (name_circuit,voltage_circuit,current,eletricCharge,wireGauge_circuit) "
                    + "VALUES('" + newCircuit.getName()+ "','" + newCircuit.getVoltage()+ "','" + newCircuit.getCurrent()+ "','" + newCircuit.getElectricCharge() +"');";
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
                System.out.println("Fail to disconnect" + e.getMessage());
                status = false;
            }
        }
        return status;
    }
    
    public void readCircuit(Circuit newCircuit) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Generating your report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM circuit ORDER BY id");

            while (res.next()) {
                newCircuit.setId(res.getInt("id"));
                newCircuit.setName(res.getString("name_circuit"));
                newCircuit.setVoltage(res.getInt("voltage_circuit"));
                newCircuit.setCurrent(res.getFloat("current"));
                newCircuit.setElectricCharge(res.getInt("eletricCharge"));
                newCircuit.setWireGauge(res.getDouble("wireGauge_circuit"));
                newCircuit.setFkId(res.getInt("fk_user_id"));
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
    
    public boolean updateCircuit(Circuit newCircuit) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to update");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE circuit SET name = '" + newCircuit.getName() + "' WHERE id = " + newCircuit.getId() + ";";
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
    
    public boolean deleteCircuit(Circuit newCircuit) {
        System.out.println("Connected!! Ready to delete");
        connection = Conection.getInstance().getConnection();
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();

            String sql = "DELETE FROM circuit WHERE name = " + newCircuit.getName() + ";";
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
    
    public void dimensioningWiresCables(Circuit newCircuit) {
        newCircuit.setCurrent(newCircuit.getElectricCharge() / newCircuit.getVoltage());
        
        if (newCircuit.getCurrent() <= 6) {
            newCircuit.setWireGauge(0.5);
        } else if (newCircuit.getCurrent() <= 10) {
            newCircuit.setWireGauge(0.75);
        } else if (newCircuit.getCurrent() <= 12) {
            newCircuit.setWireGauge(1);
        } else if (newCircuit.getCurrent() <= 16) {
            newCircuit.setWireGauge(1.5);
        } else if (newCircuit.getCurrent() <= 21) {
            newCircuit.setWireGauge(2.5);
        } else if (newCircuit.getCurrent() <= 28) {
            newCircuit.setWireGauge(4);
        } else if (newCircuit.getCurrent() <= 36) {
            newCircuit.setWireGauge(6);
        } else if (newCircuit.getCurrent() <= 50) {
            newCircuit.setWireGauge(10);
        } else if (newCircuit.getCurrent() <= 68) {
            newCircuit.setWireGauge(16);
        } else if (newCircuit.getCurrent() <= 89) {
            newCircuit.setWireGauge(25);
        } else if (newCircuit.getCurrent() <= 111) {
            newCircuit.setWireGauge(35);
        } else if (newCircuit.getCurrent() <= 134) {
            newCircuit.setWireGauge(50);
        } else if (newCircuit.getCurrent() <= 171) {
            newCircuit.setWireGauge(70);
        } else if (newCircuit.getCurrent() <= 207) {
            newCircuit.setWireGauge(95);
        } else if (newCircuit.getCurrent() <= 239) {
            newCircuit.setWireGauge(120);
        } else {
            System.out.println("Invalid value.");
        }
    }
    
    public void selectionCircuitBreakersSwitches(Circuit newCircuit) {
        newCircuit.setCurrent(newCircuit.getElectricCharge() / newCircuit.getVoltage());
        
        if (newCircuit.getCurrent() < 6) {
            newCircuit.setBreaker(6);
        } else if (newCircuit.getCurrent() < 10) {
            newCircuit.setBreaker(10);
        } else if (newCircuit.getCurrent() < 16) {
            newCircuit.setBreaker(16);
        } else if (newCircuit.getCurrent() < 20) {
            newCircuit.setBreaker(20);
        } else if (newCircuit.getCurrent() <= 25) {
            newCircuit.setBreaker(25);
        } else if (newCircuit.getCurrent() <= 32) {
            newCircuit.setBreaker(32);
        } else if (newCircuit.getCurrent() <= 40) {
            newCircuit.setBreaker(40);
        } else if (newCircuit.getCurrent() <= 50) {
            newCircuit.setBreaker(50);
        } else if (newCircuit.getCurrent() <= 63) {
            newCircuit.setBreaker(63);
        } else if (newCircuit.getCurrent() <= 80) {
            newCircuit.setBreaker(80);
        } else if (newCircuit.getCurrent() <= 100) {
            newCircuit.setBreaker(100);
        } else if (newCircuit.getCurrent() <= 125) {
            newCircuit.setBreaker(125);
        } else if (newCircuit.getCurrent() <= 160) {
            newCircuit.setBreaker(160);
        } else if (newCircuit.getCurrent() <= 200) {
            newCircuit.setBreaker(200);
        } else if (newCircuit.getCurrent() <= 250) {
            newCircuit.setBreaker(250);
        } else {
            System.out.println("Invalid value.");
        }
    }
    
    public void reportCircuit(Circuit newCircuit, DefaultTableModel modelo) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Generating your report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM circuit ORDER BY id");

            while (res.next()) {
                newCircuit.setId(res.getInt("id"));
                newCircuit.setName(res.getString("name_circuit"));
                newCircuit.setVoltage(res.getInt("voltage_circuit"));
                newCircuit.setCurrent(res.getFloat("current"));
                newCircuit.setElectricCharge(res.getInt("eletricCharge"));
                newCircuit.setWireGauge(res.getDouble("wireGauge_circuit"));
                newCircuit.setFkId(res.getInt("fk_user_id"));
                modelo.addRow(new Object[]{ newCircuit.getName(),
                    newCircuit.getVoltage(), newCircuit.getCurrent(), newCircuit.getElectricCharge(), newCircuit.getWireGauge()});
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
}
