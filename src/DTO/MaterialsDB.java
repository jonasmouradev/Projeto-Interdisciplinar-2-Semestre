package DTO;

import DAO.Materials;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class MaterialsDB {
    Connection connection = null;
   
    public boolean createList(Materials materials) {
        boolean status = true;
        connection = Conection.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");
        Statement stmt = null;
       
        try {
            stmt = connection.createStatement();

            String sql = "INSERT INTO materials (name_device,power_device,voltage_device) "
                    + "VALUES('" + materials.getTotLamp()+ "',"
                    + " '" + materials.getTotTUE()+ "',"
                    + " '" + materials.getTotTUG()+ "',"
                    + " '" + materials.getWireGauge()+ "'," 
                    + " '" + materials.getSwitchboard()+ "',"
                    + " '" + materials.getTotDR()+ "'," 
                    + " '" + materials.getTotDPS()+ "'," 
                    + " '" +materials.getTotDTM()+ "');";

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
                System.out.println("Erro ao desconectar" + e.getMessage());
                status = false;
            }
        }

        return status;
    }

    public void readList(Materials materials) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Conectado!! Preparando o relatorio");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM materials ORDER BY id");

            while (res.next()) {
                materials.setTotLamp(res.getInt("tot_lamp_house"));
                materials.setTotTUG(res.getInt("tot_tug_house"));
                materials.setWireGauge(res.getInt("tot_tug_house"));
                materials.setSwitchboard(res.getInt("switchboard"));
                materials.setTotDR(res.getInt("tot_dr"));
                materials.setTotDPS(res.getInt("tot_dps"));
                materials.setTotDTM(res.getInt("tot_dtm"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }

    }

    public boolean updateList(Materials materials) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            String sql = "UPDATE materials SET name = '" + materials.getTotTUE()+ "' WHERE id = '" + materials.getFkId()+ "';";
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
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public boolean deleteList(Materials materials) {
        System.out.println("Excluir Aparelho");
        connection = Conection.getInstance().getConnection();
        System.out.println("Conectado!! Preparando a exclusão");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM materials WHERE id = '" + materials.getFkId() + "';";
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
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
    
    public void reportList(Materials materials, DefaultTableModel modelo) {
        connection = Conection.getInstance().getConnection();
        System.out.println("Conectado!! Preparando o relatorio");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM materials ORDER BY id");

            while (res.next()) {
                materials.setTotLamp(res.getInt("tot_lamp_house"));
                materials.setTotTUG(res.getInt("tot_tug_house"));
                materials.setWireGauge(res.getInt("tot_tug_house"));
                materials.setSwitchboard(res.getInt("switchboard"));
                materials.setTotDR(res.getInt("tot_dr"));
                materials.setTotDPS(res.getInt("tot_dps"));
                materials.setTotDTM(res.getInt("tot_dtm"));
                modelo.addRow(new Object[]{materials.getTotLamp(), materials.getTotTUG(),
                    materials.getWireGauge(), materials.getSwitchboard(), materials.getTotDR(),
                materials.getTotDPS(),materials.getTotDTM()});

            }
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }

    }
    
    public void listingMaterials() {
        Scanner scanf = new Scanner(System.in);
        Map<String, Double> materiais = new HashMap<>();
        materiais.put("Fio 2.5mm²", 1.5); // Exemplo de fio e preço por metro
        materiais.put("Disjuntor 15A", 10.0); // Exemplo de disjuntor e preço unitário
        // Adicione mais materiais e preços conforme necessário

        System.out.println("Listagem de Materiais");

        System.out.println("Materiais Disponíveis:");
        for (String material : materiais.keySet()) {
            System.out.println("- " + material);
        }

        System.out.print("Escolha um material: ");
        String escolha = scanf.nextLine();

        Double preco = materiais.get(escolha);
        if (preco != null) {
            System.out.println("Material selecionado: " + escolha);
            System.out.println("Preço: R$ " + preco);
        } else {
            System.out.println("Material não encontrado.");
        }
    }
}
