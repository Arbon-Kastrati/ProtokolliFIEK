package winapps;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class EmailGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private String username;
	private String password;
	private TestLogin lg = new TestLogin();
	private SendEmail sndm = new SendEmail(this);
	
	public TestLogin getLg() {
		return lg;
	}

	public SendEmail getSndm() {
		return sndm;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public static void main(String[] args) {
		EmailGUI frame = new EmailGUI();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public EmailGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setForeground(SystemColor.window);
		lblUsername.setBackground(SystemColor.textHighlightText);
		lblUsername.setBounds(94, 69, 87, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(SystemColor.window);
		lblPassword.setBounds(94, 122, 87, 24);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(191, 71, 155, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = txtUsername.getText();
				password = new String(txtPassword.getPassword());
				if(lg.checkSession(username, password)) {
					JOptionPane.showMessageDialog(null, "Authetication succeeded");
					sndm.setLocationRelativeTo(null);
					sndm.setVisible(true);
					setVisible(false);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Authentication failed,control your credentials");
					txtUsername.setText("");
					txtUsername.grabFocus();
					txtPassword.setText("");
				}
			}
		});
		btnLogin.setBounds(175, 196, 89, 23);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(191, 124, 155, 20);
		contentPane.add(txtPassword);
		
		
	}
}
