package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import DAO.Room;
import DTO.RoomDB;

public class RoomReport extends JFrame {
    private DefaultTableModel modelo;
    private JTable tabela;
    private JButton btnDelete;
    private JButton btnCreate;
    private JButton btnHouse;
    private Room room;
    private RoomDB roomDB;
    

    public RoomReport(int fk_room, int fk_house) {
        room = new Room();
        roomDB = new RoomDB();

        modelo = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 8) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }
        };

        tabela = new JTable(modelo);

        modelo.addColumn("Comodo");
        modelo.addColumn("Tipo");
        modelo.addColumn("Area");
        modelo.addColumn("Perimetro");
        modelo.addColumn("Qnt.Lampadas");
        modelo.addColumn("Qnt.TUG");
        modelo.addColumn("Qnt.TUE");
        modelo.addColumn("Selecionar");

        roomDB.reportRoom(room, modelo, fk_room);

        TableColumn selectColumn = tabela.getColumnModel().getColumn(7);
        selectColumn.setCellEditor(tabela.getDefaultEditor(Boolean.class));
        selectColumn.setCellRenderer(tabela.getDefaultRenderer(Boolean.class));

        tabela.setPreferredScrollableViewportSize(new Dimension(700, 400));
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        c.add(scrollPane);

        btnDelete = new JButton("Excluir");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarLinhasSelecionadas();
            }
        });
        c.add(btnDelete);
        
        btnCreate = new JButton("Criar Comodo");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewRoom newRoom = new NewRoom(fk_room,fk_house);
                newRoom.setVisible(true);
                dispose();
            }
        });
        c.add(btnCreate);
        
        btnHouse = new JButton("Ver Casas");
        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HouseReport houseReport = new HouseReport(room.getFkId());
                houseReport.setVisible(true);
                dispose();
            }
        });
        c.add(btnHouse);

        setSize(800, 520);
        setTitle("Relatorio de Comodos");

    }

    private void deletarLinhasSelecionadas() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            Boolean selected = (Boolean) model.getValueAt(i, 7); // Ajuste o número da coluna conforme necessário
            if (selected != null && selected) {
                // Cria um objeto Room com os dados da linha
                Room roomToDelete = new Room();
                String name = (String) model.getValueAt(i, 0);

                roomToDelete.setName(name);

                    // Chama o metodo de exclusão na classe RoomDB
                roomDB.deleteRoom(roomToDelete);

                    // Remove a linha da tabela localmente
                model.removeRow(i);
                
            }
        }
    }
}