package DTO;

import DAO.Device;
import DAO.House;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class HouseDB {
    Connection connection = null;
   
    public boolean createHouse(House newHouse) {
        boolean status = true;
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to create");
        Statement stmt = null;
       
        try {
            stmt = connection.createStatement();

            String sql = "INSERT INTO house (name_house, tot_circuit, tot_room, tot_consumption_house, tot_devices_house, tot_power_house, tot_charge_house,maximum_demand,tot_demand, demand_factor, tot_phase, fk_user_id) "
                + "VALUES('" + newHouse.getName() + "','"
                + newHouse.getTotCircuit()+ "','"
                + newHouse.getTotRoom()+ "','" 
                + newHouse.getTotConsumption()+"','"
                + newHouse.getTotDevices() + "','"    
                + newHouse.getTotPower()+ "','" 
                + newHouse.getTotCharge()+ "','" 
                + newHouse.getMaximumDemand() + "','" 
                + newHouse.getTotDemand() + "','" 
                + newHouse.getDemandFactor()+ "','" 
                + newHouse.getTotPhase()+ "','"
                +newHouse.getFk_house()+ "');";
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

    public void readHouse(House newHouse) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Generating house report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM house WHERE id = "+ newHouse.getId() +" ORDER BY id");

            while (res.next()) {
                newHouse.setId(res.getInt("id"));
                newHouse.setName(res.getString("name_house"));
                newHouse.setTotCircuit(res.getInt("tot_circuit"));
                newHouse.setTotRoom(res.getInt("tot_room"));
                newHouse.setTotConsumption(res.getInt("tot_consumption_house"));
                newHouse.setTotDevices(res.getInt("tot_devices_house"));
                newHouse.setTotPower(res.getInt("tot_power_house"));
                newHouse.setTotCharge(res.getInt("tot_charge_house"));
                newHouse.setMaximumDemand(res.getDouble("maximum_demand"));
                newHouse.setTotDemand(res.getDouble("tot_demand"));
                newHouse.setDemandFactor(res.getDouble("demand_factor"));
                newHouse.setTotPhase(res.getByte("tot_phase"));
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

    public boolean updateHouse(House newHouse) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to update");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            String sql = "UPDATE house SET tot_room = '" + newHouse.getTotRoom()+ "' WHERE id = " + newHouse.getId() + ";";
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
    
    public boolean updateHouse(House newHouse,int id) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected and ready to update");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            String sql = "UPDATE house\n" +
"SET tot_room = '" + newHouse.getTotRoom()+ "', tot_devices_house = '" + newHouse.getTotDevices()+ "', tot_power_house = '" + newHouse.getTotPower()+ "', tot_charge_house = '" + newHouse.getTotCharge()+ "', tot_demand = '" + newHouse.getTotDemand()+"', maximum_demand = '" + newHouse.getMaximumDemand()+"', demand_factor = '" + newHouse.getDemandFactor()+"', tot_phase = '" + newHouse.getTotPhase()+ "'\n" +
"WHERE id = "+ id +";";
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

    public boolean deleteHouse(House newHouse) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected!! Ready to delete");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            if (newHouse.getTotRoom()>0){
                String sqll = "ALTER TABLE room\n" +
                              "DROP FOREIGN KEY room_ibfk_1,\n" +
                              "ADD FOREIGN KEY (fk_house_id) REFERENCES house(id)\n" +
                              "ON DELETE CASCADE;";
                String sql = "DELETE FROM house WHERE name_house = '" + newHouse.getName() + "';";
                System.out.println("SQL: " + sql);
                stmt.executeUpdate(sqll);
                stmt.executeUpdate(sql);
            } else {
                String sql = "DELETE FROM house WHERE name_house = '" + newHouse.getName() + "';";
                System.out.println("SQL: " + sql);
                stmt.executeUpdate(sql);
            }
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
    
    public void reportHouse(House newHouse, DefaultTableModel modelo, int id_user) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Generating house report");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM house WHERE fk_user_id = "+ id_user +" ORDER BY id");

            while (res.next()) {
                newHouse.setId(res.getInt("id"));
                newHouse.setName(res.getString("name_house"));
                newHouse.setTotCircuit(res.getInt("tot_circuit"));
                newHouse.setTotRoom(res.getInt("tot_room"));
                newHouse.setTotConsumption(res.getInt("tot_consumption_house"));
                newHouse.setTotDevices(res.getInt("tot_devices_house"));
                newHouse.setTotPower(res.getInt("tot_power_house"));
                newHouse.setTotCharge(res.getInt("tot_charge_house"));
                newHouse.setMaximumDemand(res.getDouble("maximum_demand"));
                newHouse.setTotDemand(res.getDouble("tot_demand"));
                newHouse.setDemandFactor(res.getDouble("demand_factor"));
                newHouse.setTotPhase(res.getByte("tot_phase"));
                modelo.addRow(new Object[]{newHouse.getName(),newHouse.getTotCircuit(),newHouse.getTotRoom(),newHouse.getTotConsumption(),newHouse.getTotDevices(),newHouse.getTotPower(),newHouse.getTotCharge(),
                newHouse.getMaximumDemand(),newHouse.getTotDemand(),newHouse.getDemandFactor(),newHouse.getTotPhase()});

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
    
    public void calculatorElectricChargeDB(House newHouse) {
            //Calculate TotCharge
            newHouse.setTotCharge((newHouse.getTotPower() * 120) / 100);
    }
    
    public void demandFactorCalculatorDB(House newHouse) {
        //Calculate Demand Factor
        newHouse.setDemandFactor(newHouse.getMaximumDemand() / newHouse.getTotDemand());
        if (newHouse.getTotDemand() == 0) {
            throw new IllegalArgumentException("A demanda total não pode ser zero.");
        }
    }
    
    public boolean sumPowerAndUpdateHouse(Device device) {
        boolean status = true;
        connection = Conection.getInstance().getConnection();
        System.out.println("Connected! Start calculating... ");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            // Get data from database, filtered by fk_house_id
            String query = "SELECT SUM(power) FROM device WHERE fk_house_id = " + device.getFkId();
            ResultSet res = stmt.executeQuery(query);

            if (res.next()) {
                int totalPower = res.getInt(1);

                // Atualizar a coluna tot_power_house na tabela house
                String updateQuery = "UPDATE house SET tot_power_house = " + totalPower + " WHERE id = " + device.getFkId();
                stmt.executeUpdate(updateQuery);

                System.out.println("Total Power: " + totalPower + " updated in house table");
            }

            status = true;
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERROR! Fail to disconnect: " + e.getMessage());
            }
        }
        return status;
    }
}
