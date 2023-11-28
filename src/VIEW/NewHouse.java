package VIEW;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.House;
import DAO.Room;
import DTO.Conection;
import DTO.HouseDB;
import DTO.RoomDB;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class NewHouse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHouseName;
	
	private House house;
	private HouseDB houseDB;
        private Room room;
        private RoomDB roomDB;

	public NewHouse(int fk_house) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Criar Casa");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				house = new House();
				houseDB = new HouseDB();
				
				house.setName(txtHouseName.getText());
                                house.setFk_house(fk_house);
                                
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
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(162, 197, 122, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome da Casa");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(145, 63, 155, 34);
		contentPane.add(lblNewLabel);
		
		txtHouseName = new JTextField();
		txtHouseName.setBounds(145, 108, 155, 34);
		contentPane.add(txtHouseName);
		txtHouseName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NewHouse.class.getResource("/icons/imgNewHouse.png")));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
}