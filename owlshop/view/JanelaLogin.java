package owlshop.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JanelaLogin extends JPanel {
	public JTextField tfUsername;
	public JPasswordField tfPassword;
	private JLabel lbTitulo;
	private JPanel painelCentral;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JPanel painelSul;
	public JButton btLogin;
	private JLabel lbMessage;

	public JanelaLogin() {
		setLayout(new BorderLayout(0, 0));
		
		lbTitulo = new JLabel("OwlShop Login");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbTitulo, BorderLayout.NORTH);
		
		painelCentral = new JPanel();
		add(painelCentral, BorderLayout.CENTER);
		painelCentral.setLayout(null);
		
		lbUsername = new JLabel("Username:");
		lbUsername.setBounds(20, 29, 131, 26);
		lbUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		painelCentral.add(lbUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(215, 29, 225, 26);
		tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		painelCentral.add(tfUsername);
		tfUsername.setColumns(10);
		
		lbPassword = new JLabel("Password:");
		lbPassword.setBounds(20, 84, 131, 26);
		lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbPassword.setHorizontalAlignment(SwingConstants.LEFT);
		painelCentral.add(lbPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(215, 81, 225, 26);
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		painelCentral.add(tfPassword);
		
		lbMessage = new JLabel("");
		lbMessage.setBounds(0, 121, 450, 47);
		painelCentral.add(lbMessage);
		lbMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lbMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		painelSul = new JPanel();
		add(painelSul, BorderLayout.SOUTH);
		painelSul.setLayout(new GridLayout(1, 0, 0, 0));
		
		btLogin = new JButton("Log in");
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		painelSul.add(btLogin);

	}
	
	public void showMessage(String Message){
		lbMessage.setText(Message);
	}

}
