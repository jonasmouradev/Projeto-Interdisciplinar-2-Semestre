package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class About extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * NewRoom the frame.
	 */
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("v0.5");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 230, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Novidades em Breve...");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(253, 222, 171, 28);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(About.class.getResource("/icons/icons8-users-48.png")));
		lblNewLabel_2.setBounds(376, 11, 48, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Desenvolvido por: Jonas da Silva Moura");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 11, 317, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Gabriel Mendes Fonseca");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(155, 41, 198, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(About.class.getResource("/icons/16282276_rm222batch2-mind-03.jpg")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 434, 261);
		panel.add(lblNewLabel);
	}
}
