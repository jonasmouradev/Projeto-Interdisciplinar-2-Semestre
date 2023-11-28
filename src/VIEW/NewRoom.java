package VIEW;

import java.awt.EventQueue;

import DTO.HouseDB;
import DTO.RoomDB;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import DAO.House;
import DAO.Room;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NewRoom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRoomName;
	private JTextField txtArea;
	private JTextField txtPerimeter;
	
	private Room room;
	private RoomDB roomDB;
	private House house;
	private HouseDB houseDB;
	
	private int indice;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */


	/**
	 * NewRoom the frame.
	 */
	public NewRoom(int fk_room, int fk_house) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 584, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCleanField = new JButton("Limpar");
		btnCleanField.setBackground(new Color(255, 255, 255));
		btnCleanField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCleanField.setFont(new Font("Arial", Font.BOLD, 16));
		btnCleanField.setBounds(328, 367, 150, 45);
		
		btnCleanField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
				try {
					txtRoomName.setText("");
					txtArea.setText("");
					txtPerimeter.setText("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(NewRoom.this, "Ocorreu um erro ao abrir a janela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
		
		txtType = new JTextField();
		txtType.setBounds(355, 157, 150, 30);
		panel.add(txtType);
		txtType.setColumns(10);

		panel.add(btnCleanField);
		
		
		
		txtRoomName = new JTextField();
		txtRoomName.setBounds(67, 157, 150, 30);
		panel.add(txtRoomName);
		txtRoomName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do Comodo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(67, 117, 150, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(355, 117, 150, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Area");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(67, 209, 150, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Perimetro");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(355, 209, 150, 30);
		panel.add(lblNewLabel_3);
		
		txtArea = new JTextField();
		txtArea.setBounds(67, 260, 150, 30);
		panel.add(txtArea);
		txtArea.setColumns(10);
		
		txtPerimeter = new JTextField();
		txtPerimeter.setBounds(355, 260, 150, 30);
		panel.add(txtPerimeter);
		txtPerimeter.setColumns(10);
		
        JButton btnConfirm = new JButton("");
        btnConfirm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                room = new Room();
                roomDB = new RoomDB();
                house = new House();
                houseDB = new HouseDB(); 
                
                room.setName(txtRoomName.getText());
                room.setArea(Float.parseFloat(txtArea.getText()));
                room.setPerimeter(Float.parseFloat(txtPerimeter.getText()));
                room.setType(txtType.getText());
                room.setFkId(fk_room);
                
                roomDB.calculatorTugLampDB(room);
                roomDB.createRoom(room);
                
                house.setId(fk_room);
                houseDB.readHouse(house);
                house.setTotRoom(house.getTotRoom()+1);
                houseDB.updateHouse(house);
                
                Tela tela = new Tela(fk_room,fk_house);
                tela.setVisible(true);
                dispose();
            }
        });
		btnConfirm.setIcon(new ImageIcon(NewRoom.class.getResource("/icons/Simple Lined White Login Page Wireframe Mobile UI Prototype.png")));
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBounds(67, 367, 236, 45);
		panel.add(btnConfirm);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(NewRoom.class.getResource("/icons/19114075_6079753.jpg")));
		lblNewLabel_4.setBounds(0, 0, 584, 461);
		panel.add(lblNewLabel_4);
	}
}