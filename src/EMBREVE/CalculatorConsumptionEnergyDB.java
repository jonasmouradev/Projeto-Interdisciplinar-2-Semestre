package EMBREVE;

//import data.Device;
//import data.House;
//import java.awt.List;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Scanner;

public class CalculatorConsumptionEnergyDB {

//    Connection connection = null;
//
//    public boolean calculadoraConsumoEnergia() {
//        boolean status = false;
//        House newHouse = new House();
//        connection = Conection.getInstance().getConnection();
//        System.out.println("Connected! Start calculating... ");
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//
//            //Get data from database
//            ResultSet res = stmt.executeQuery("SELECT * FROM comodo ORDER BY id");
//            while (res.next()) {
//                Device device = new Device();
//                device.setName(res.getString("name"));
//                device.setPower(res.getInt("power"));
//                device.setVoltage(res.getInt("voltage"));
//            }
//
////            Device chosenDevice = devices.stream().filter(device -> device.getName().equals(escolha)).findFirst().orElse(null);
////            if (chosenDevice != null) {
////                System.out.print("Horas de uso por dia: ");
////                double horasUso = scanf.nextDouble();
////                consumoTotal += (chosenDevice.getPower() / 1000) * horasUso; // Converter para kW
////
////                scanf.nextLine(); // Limpa o buffer
////            } else {
////                System.out.println("Aparelho não encontrado.");
////            }
////        }
////
////        String insertQuery = "INSERT INTO comodo (tot_ilu,tot_TUG,tot_TUE) VALUES (?, ?, ?)";
////
////        try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {
////            pst.setDouble(1, newHouse.getTotIlu());
////            pst.setDouble(2, newHouse.getTotTUG());
////            pst.setDouble(3, newHouse.getTotTUE());
////            pst.executeUpdate();
////            status = true;
////        }
//            }catch (SQLException ex) {
//        System.out.println("Erro SQL: " + ex.getMessage());
//    
//                }finally {
//        try {
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            System.out.println("Erro ao desconectar" + e.getMessage());
//        }
//       return status;
//    }
//        }
    }

//double consumoTotal = 0;
//
//        for (int i = 1; i <= numAparelhos; i++) {
//            System.out.println("Aparelho " + i + ":");
//            System.out.println("Escolha um aparelho:");
//
//            for (String aparelho : aparelhos.keySet()) {
//                System.out.println("- " + aparelho);
//            }
//
//            System.out.print("Escolha: ");
//            String escolha = scanf.nextLine();
//
//            Double consumoAparelho = aparelhos.get(escolha);
//            if (consumoAparelho != null) {
//                System.out.print("Horas de uso por dia: ");
//                double horasUso = scanf.nextDouble();
//                consumoTotal += (consumoAparelho / 1000) * horasUso; // Converter para kW
//
//                scanf.nextLine(); // Limpa o buffer
//            } else {
//                System.out.println("Aparelho não encontrado.");
//            }
//        }
//        System.out.println("Consumo total de energia diário: " + consumoTotal + " kWh");
//        }
