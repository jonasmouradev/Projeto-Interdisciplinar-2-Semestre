package DTO;

import DAO.Device;
import DAO.House;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DeviceDB {
    Connection connection = null;
   
    public boolean createDevice(Device newDevice) {
        boolean status = true;
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to create");
        Statement stmt = null;
       
        try {
            stmt = connection.createStatement();

            String sql = "INSERT INTO device (name_device,power_device,voltage_device,tot_consumption_device,used_hours) "
                    + "VALUES('" + newDevice.getName() + "','"
                    + newDevice.getPower() + "','" 
                    + newDevice.getVoltage() + "','" 
                    + newDevice.getTotConsumption() + "','" 
                    + newDevice.getUsedHours()+"');";
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
    
    public void readDevice(Device newDevice) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Generating your report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM device ORDER BY id");

            while (res.next()) {
                newDevice.setId(res.getInt("id"));
                newDevice.setName(res.getString("name_device"));
                newDevice.setPower(res.getInt("power_device"));
                newDevice.setVoltage(res.getInt("voltage_device"));
                newDevice.setTotConsumption(res.getDouble("tot_consumption_device"));
                newDevice.setUsedHours(res.getDouble("used_hours"));
                newDevice.setFkId(res.getInt("fk_house_id"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }

    }

    public boolean updateDevice(Device newDevice) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to update");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            String sql = "UPDATE device SET name = '" + newDevice.getName() + "' WHERE id = '" + newDevice.getId() + "';";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }
    }

    public boolean deleteDevice(Device device) {
        System.out.println("Connected!! Ready to delete");
        connection = Conection.getInstance().getConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            String sql = "DELETE FROM device WHERE id = " + device.getId() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnet" + e.getMessage());
            }
        }
    }
    
    public void reportDevice(Device newDevice, DefaultTableModel modelo) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Generating your report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM device ORDER BY id");

            while (res.next()) {
                newDevice.setId(res.getInt("id"));
                newDevice.setName(res.getString("name_device"));
                newDevice.setPower(res.getInt("power_device"));
                newDevice.setVoltage(res.getInt("voltage_device"));
                newDevice.setTotConsumption(res.getDouble("tot_consumption_device"));
                newDevice.setUsedHours(res.getDouble("used_hours"));
                newDevice.setFkId(res.getInt("fk_house_id"));
                modelo.addRow(new Object[]{newDevice.getId(), newDevice.getName(),
                    newDevice.getPower(), newDevice.getVoltage()});

            }
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
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
