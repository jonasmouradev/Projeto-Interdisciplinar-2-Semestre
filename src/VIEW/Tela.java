package VIEW;

import DAO.House;
import DTO.HouseDB;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCharge;
	private JLabel lblNewLabel_1;
	private JTextField txtVoltage;
        private House house;
        private HouseDB houseDB;
        private JLabel lblNewLabel_2;
        private JButton btnNewButton_1;
        private JButton btnCleaner;

	public Tela(int fk_room, int fk_house) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnCleaner = new JButton("Limpar");
		btnCleaner.setBackground(new Color(255, 255, 255));
		btnCleaner.setBorderPainted(false);
		btnCleaner.setBorder(null);
		btnCleaner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCharge.setText("");
				txtVoltage.setText("");
			}
		});
		btnCleaner.setFont(new Font("Arial", Font.BOLD, 14));
		btnCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCleaner.setBounds(342, 308, 143, 51);
		panel.add(btnCleaner);
		
		txtCharge = new JTextField();
		txtCharge.setBounds(360, 171, 125, 30);
		panel.add(txtCharge);
		txtCharge.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Carga Total");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 82, 125, 20);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tens\u00E3o");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(360, 82, 125, 20);
		panel.add(lblNewLabel_1);
		
		txtVoltage = new JTextField();
		txtVoltage.setBounds(124, 171, 125, 30);
		panel.add(txtVoltage);
		txtVoltage.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int potencia = Integer.parseInt(txtVoltage.getText());
				int tensao = Integer.parseInt(txtCharge.getText());
                                house = new House();
                                houseDB = new HouseDB();
                                house.setTotRoom(1);
                                house.setTotDevices(house.getTotRoom()*2);
                                house.setTotPower(potencia);
                                houseDB.calculatorElectricChargeDB(house);
                                house.setTotDemand(house.getTotCharge());
                                houseDB.demandFactorCalculatorDB(house);
                                if (tensao>127){
                                    house.setTotPhase(2);
                                } else if (tensao>220){
                                    house.setTotPhase(3);
                                } else {
                                     house.setTotPhase(1);
                                }
                                
                                houseDB.updateHouse(house,fk_room);
                                
                                HouseReport housereport = new HouseReport(fk_house);
                                housereport.setVisible(true);
                                dispose();
			}
		});
		btnNewButton.setBounds(112, 308, 166, 51);
		panel.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setIcon(new ImageIcon(Tela.class.getResource("/ICONS/19114075_6079753.jpg")));
		lblNewLabel_2.setBounds(0, 0, 600, 500);
		panel.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(438, 444, 100, 40);
		panel.add(btnNewButton_1);
	}
}
