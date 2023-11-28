package VIEW;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import DTO.LoginDB;
import DAO.Login;
import DTO.Conection;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField campoLogin;
	private JPasswordField campoSenha;

	private MainMenu mainMenu;
	private JLabel lblNewLabel_1;

	

	public LoginScreen() {
		
		setTitle("Acesso ao sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirma = new JButton("");
		btnConfirma.setBounds(100, 304, 236, 45);
		btnConfirma.setContentAreaFilled(false);
		btnConfirma.setIcon(new ImageIcon(LoginScreen.class.getResource("/icons/Simple Lined White Login Page Wireframe Mobile UI Prototype.png")));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name;
				String keyword;
				
				LoginDB acesso = new LoginDB();
				Login login = new Login();
				
				name = campoLogin.getText();
				keyword = campoSenha.getText();
				
				login.setName(name);
				login.setPassword(keyword);
				
                                    if(acesso.verifyAcess(login) == true) {
                                    
                                    Connection connection = Conection.getInstance().getConnection();
                                    Statement stmt = null;

                                    try
                                    {
                                        stmt = connection.createStatement();
                                        ResultSet res = stmt.executeQuery("SELECT * FROM users WHERE name = '"+ login.getName()+"'");

                                        while(res.next())
                                        {
                                            login.setId(res.getInt("id"));
                                        }

                                    }
                                    catch (SQLException ex)
                                    {
                                        System.out.println(ex.getMessage());
                                    }

                                    mainMenu = new MainMenu(login.getId());
                                    mainMenu.setVisible(true);
                                    dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro nos dados informados", "Erro", JOptionPane.ERROR_MESSAGE);
				}
								
			}
		});
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnConfirma);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setBounds(5, 77, 76, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(120, 71, 289, 31);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(5, 173, 76, 19);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(120, 167, 289, 31);
		contentPane.add(campoSenha);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/icons/6166980_17545.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 411);
		contentPane.add(lblNewLabel_1);
	}
//	    public static void main(String[] args) {
//	    	LoginScreen log;
//	        log = new LoginScreen();
//	        log.setVisible(true);
//	    }
}
