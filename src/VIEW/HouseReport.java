package VIEW;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.House;
import DAO.Room;
import DTO.Conection;
import DTO.HouseDB;

public class HouseReport extends JFrame {
    private DefaultTableModel modelo;
    private JTable tabela;
    private JButton btnDelete;
    private JButton btnAction;
    private House house;
    private HouseDB houseDB;
    private Room room;

    public HouseReport(int fk_house) {
        house = new House();
        houseDB = new HouseDB();
        houseDB.readHouse(house);

        modelo = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 11) {
                    return Object.class;
                } else {
                    return String.class;
                }
            }
        };

        class TableCellButtonEditor extends DefaultCellEditor {
            protected JButton buttonAction;

            public TableCellButtonEditor(JCheckBox checkBox) {
                super(checkBox);

                btnAction = new JButton();
;
        		btnAction.setFont(new Font("Arial", Font.BOLD, 14));
        		btnAction.setForeground(new Color(255, 255, 255));

                buttonAction = new JButton();
                buttonAction.setFont(new Font("Arial", Font.BOLD, 14));
                buttonAction.setForeground(new Color(255, 255, 255));

                buttonAction.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = tabela.getSelectedRow();
                        if (selectedRow != -1) {
                            RoomReport relatorio = new RoomReport(house.getId(),house.getFk_house());
                            relatorio.setVisible(true);
                            dispose();
                        }
                    }
                });
            }
            
            

            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                if (isSelected) {
                    buttonAction.setForeground(table.getSelectionForeground());
                    buttonAction.setBackground(table.getSelectionBackground());
                } else {
                    buttonAction.setForeground(table.getForeground());
                    buttonAction.setBackground(table.getBackground());
                }
                buttonAction.setText("Editar");
                return buttonAction;

            }
        }

        tabela = new JTable(modelo);

        modelo.addColumn("Nome da Casa");
        modelo.addColumn("Circuitos");
        modelo.addColumn("Comodos");
        modelo.addColumn("Consumo");
        modelo.addColumn("Aparelhos");
        modelo.addColumn("Potencia da casa");
        modelo.addColumn("Carga");
        modelo.addColumn("Demanda maxima");
        modelo.addColumn("Total Demanda");
        modelo.addColumn("Fator de Demanda");
        modelo.addColumn("Total Fase");
        modelo.addColumn("acoes"); // Nova coluna para os botoes
        modelo.addColumn("Selecionar");

        // Adiciona os dados na tabela
        houseDB.reportHouse(house, modelo, fk_house);

        TableColumn selectColumn = tabela.getColumnModel().getColumn(11);
        selectColumn.setCellEditor(tabela.getDefaultEditor(Boolean.class));
        selectColumn.setCellRenderer(tabela.getDefaultRenderer(Boolean.class));
        tabela.setRowHeight(30);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            if (i != 11) {
                tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }

        // Adiciona a coluna de botoes a direita
        TableColumn buttonColumn = tabela.getColumnModel().getColumn(12);
        buttonColumn.setCellRenderer(new TableCellButtonRenderer()); // Use the modified renderer class
        buttonColumn.setCellEditor(new TableCellButtonEditor(new JCheckBox()));

        tabela.setPreferredScrollableViewportSize(new Dimension(1200, 500));
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

        setSize(1250, 600);
        setTitle("Relatorio de Casas");
    }

    private void deletarLinhasSelecionadas() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        int rowCount = model.getRowCount();

        // Itera sobre as linhas da tabela
        for (int i = rowCount - 1; i >= 0; i--) {
            Boolean selected = (Boolean) model.getValueAt(i, 11);

            // Verifica se a linha esta selecionada
            if (Boolean.TRUE.equals(selected)) {
                String name = (String) model.getValueAt(i, 0);

                // Cria um objeto House com o nome
                House houseToDelete = new House();
                houseToDelete.setName(name);

                // Chama o metodo de exclusao na classe HouseDB
                houseDB.deleteHouse(houseToDelete);

                // Remove a linha da tabela localmente
                model.removeRow(i);
            }
        }
    }

    class TableCellButtonRenderer extends JButton implements TableCellRenderer {
        public TableCellButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton buttonAction;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            room = new Room();
            buttonAction = new JButton("Editar");
            buttonAction.setOpaque(true);
            buttonAction.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = tabela.getSelectedRow();
                    if (selectedRow != -1) {
                        house = new House();
                            houseDB = new HouseDB();

                            if(houseDB.createHouse(house) == true) {

                                Connection connection = Conection.getInstance().getConnection();
                                Statement stmt = null;

                                try
                                {
                                    stmt = connection.createStatement();
                                        ResultSet res = stmt.executeQuery("SELECT * FROM house WHERE name_house = '"+ house.getName() +"'");
                                    while(res.next())
                                    {
                                        house.setId(res.getInt("id"));
                                    }

                                }
                                catch (SQLException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }

                                NewRoom newRoom = new NewRoom(house.getId(),house.getFk_house());
                                newRoom.setVisible(true);
                                dispose();
                            }
                            else
                            {
                                    JOptionPane.showMessageDialog(null, "Erro nos dados informados", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                buttonAction.setForeground(table.getSelectionForeground());
                buttonAction.setBackground(table.getSelectionBackground());
            } else {
            	buttonAction.setForeground(table.getForeground());
            	buttonAction.setBackground(table.getBackground());
            }
            buttonAction.setText((value == null) ? "" : value.toString());
            return buttonAction;
        }
    }
}

