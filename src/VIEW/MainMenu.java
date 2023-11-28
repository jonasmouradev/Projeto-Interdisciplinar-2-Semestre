package VIEW;

import DAO.House;
import DTO.Conection;
import DTO.HouseDB;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
        private House house;
        private HouseDB houseDB;
        

	public MainMenu(int fk_house) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 784, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnOpenProject = new JButton("Abrir Projeto Existente");
		btnOpenProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOpenProject.setBounds(194, 410, 220, 60);
				btnOpenProject.setFont(new Font("Arial", Font.BOLD, 17));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOpenProject.setBounds(199, 415, 210, 50);
				btnOpenProject.setFont(new Font("Arial", Font.BOLD, 16));
			}
		});

		btnOpenProject.setRequestFocusEnabled(false);
		btnOpenProject.setFocusPainted(false);
		btnOpenProject.setBorderPainted(false);
		btnOpenProject.setFont(new Font("Arial", Font.BOLD, 16));
		btnOpenProject.setSelected(true);
		btnOpenProject.setHideActionText(true);
		btnOpenProject.setForeground(new Color(0, 0, 0));
		btnOpenProject.setBounds(199, 415, 210, 50);
		btnOpenProject.setBorder(null);
		btnOpenProject.setBackground(new Color(255, 255, 255));
		
		btnOpenProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseReport houseReport = new HouseReport(fk_house);
				houseReport.setVisible(true);
			}
		});
		
		JButton btnCreate = new JButton("Criar Projeto");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreate.setBounds(414, 410, 187, 60);
				btnCreate.setFont(new Font("Arial", Font.BOLD, 17));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCreate.setBounds(419, 415, 177, 50);
				btnCreate.setFont(new Font("Arial", Font.BOLD, 16));
			}
		});

		
		btnCreate.setRequestFocusEnabled(false);
		btnCreate.setSelected(true);
		btnCreate.setBorderPainted(false);
		btnCreate.setFont(new Font("Arial", Font.BOLD, 16));
		btnCreate.setForeground(new Color(255, 255, 255));
		btnCreate.setBounds(419, 415, 177, 50);
		btnCreate.setHideActionText(true);
		btnCreate.setBorder(null);
		btnCreate.setBackground(new Color(0, 0, 0));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOpenProject.setBackground(new Color(255, 255, 255));
				
				NewHouse newHouse = new NewHouse(fk_house);
				newHouse.setVisible(true);
			}
		});
		panel.add(btnCreate);
		

		panel.add(btnOpenProject);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(236, 125, 88, 90);
		lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/iconLightning.png")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/tittleWattVision.png")));
		lblNewLabel.setBounds(329, 146, 202, 39);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(209, 241, 252));
		menuBar.setBounds(0, 0, 784, 51);
		panel.add(menuBar);
		
		JMenu menuNew = new JMenu("Novo Projeto");
		menuNew.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-document-48.png")));
		menuNew.setSelectedIcon(null);
		menuBar.add(menuNew);
		menuNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
				try {
					NewHouse newHouse = new NewHouse(fk_house);
					newHouse.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(MainMenu.this, "Ocorreu um erro ao abrir a janela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
		
		menuNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreate.setBounds(414, 410, 187, 60);
//				btnCreate.setFont(new Font("Arial", Font.BOLD, 17));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCreate.setBounds(419, 415, 177, 50);
//				btnCreate.setFont(new Font("Arial", Font.BOLD, 16));
			}
		});
		
		JMenu menuReport = new JMenu("Relatorio");
		menuReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                        HouseReport relatorio = new HouseReport(fk_house);
                        relatorio.setVisible(true);
                        dispose();
                    }
		});
		
		menuReport.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-report-48.png")));
		menuBar.add(menuReport);
		menuReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOpenProject.setBounds(194, 410, 220, 60);
//				btnOpenProject.setFont(new Font("Arial", Font.BOLD, 17));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOpenProject.setBounds(199, 415, 210, 50);
//				btnOpenProject.setFont(new Font("Arial", Font.BOLD, 16));
			}
		});

		
		
		JMenu menuHelp = new JMenu("Ajuda");
		menuHelp.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-help-48.png")));
		menuBar.add(menuHelp);
		
		JMenuItem helpAbout = new JMenuItem("Sobre");
		helpAbout.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-about-48.png")));
		menuHelp.add(helpAbout);
		helpAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
				try {
					About about = new About();
					about.setVisible(true);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(MainMenu.this, "Ocorreu um erro ao abrir a janela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
        });
		
		JMenuItem helpDocumentation = new JMenuItem("Documentacao");
		helpDocumentation.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-document-48.png")));
		menuHelp.add(helpDocumentation);
		 helpDocumentation.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
                    URI uri = null;
					try {
						uri = new URI("https://fatecspgov-my.sharepoint.com/personal/gabriel_fonseca14_fatec_sp_gov_br/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fgabriel_fonseca14_fatec_sp_gov_br%2FDocuments%2FCollege%2F2°%20Semestre%2FAcelera%2FDocumentação&ct=1701145442306&or=Teams-HL&ga=1&LOF=1");
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(MainMenu.this, "Ocorreu um erro ao abrir a janela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
                    openWebpage(uri);
	            }
	        });
		
		JMenu mnNewMenu = new JMenu("Configuracoes");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Em breve.");
			}
		});
		mnNewMenu.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-settings-40.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menuExit = new JMenu("Sair");
		menuExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginScreen log = new LoginScreen();
				log.setVisible(true);
				dispose();
			}
		});
		menuExit.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-exit.gif")));
		menuBar.add(menuExit);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/15151445_5559852.jpg")));
		lblNewLabel_2.setBounds(0, 51, 790, 510);
		panel.add(lblNewLabel_2);
	}
	 private static void openWebpage(URI uri) {
	            Desktop desktop = Desktop.getDesktop();
	            try {
	                desktop.browse(uri);
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir a janela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }

	    }
}
