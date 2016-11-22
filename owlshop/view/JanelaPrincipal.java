package owlshop.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import owlshop.model.Item;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel label01;
	public JLabel lbUsername;
	private JLabel label02;
	public JLabel lbWallet;
	public JButton btAdicionarFundos;
	private JLabel label03;
	public JButton btLogOut;
	private JLabel lbCompreRp;
	public JButton btComprarRp;
	private JLabel lbPrecoRP_;
	private JLabel lbEstoqueRP_;
	private JPanel painelImagemRP;
	private JLabel img01;
	public JLabel lbPrecoRP;
	public JLabel lbEstoqueRP;
	private JMenuBar menuBar;
	private JLabel lbComunicado;
	public JComboBox<Item> RPComboBox;

	public JanelaPrincipal() {
		setTitle("OwlShop OpenSource Software v0.1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		label01 = new JLabel("Logado como: ");
		label01.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(label01);
		
		lbUsername = new JLabel("null");
		lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(lbUsername);
		
		label02 = new JLabel("      Wallet: BTC ");
		label02.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(label02);
		
		lbWallet = new JLabel("0.00000000");
		lbWallet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(lbWallet);
		
		btAdicionarFundos = new JButton("Adicionar Fundos");
		menuBar.add(btAdicionarFundos);
		
		btLogOut = new JButton("Log Out");
		btLogOut.setToolTipText("Clique no X");
		btLogOut.setEnabled(false);
		menuBar.add(btLogOut);
		
		label03 = new JLabel("                                                                                                                                                                       ");
		menuBar.add(label03);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbCompreRp = new JLabel("Compre RiotPoints");
		lbCompreRp.setHorizontalAlignment(SwingConstants.CENTER);
		lbCompreRp.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbCompreRp.setBounds(10, 11, 165, 21);
		contentPane.add(lbCompreRp);
		
		RPComboBox = new JComboBox<Item>();
		RPComboBox.setBounds(187, 10, 422, 26);
		contentPane.add(RPComboBox);
		
		btComprarRp = new JButton("Comprar RP");
		btComprarRp.setBounds(621, 12, 120, 23);
		contentPane.add(btComprarRp);
		
		lbPrecoRP_ = new JLabel("Preco(BTC): ");
		lbPrecoRP_.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbPrecoRP_.setBounds(187, 43, 120, 14);
		contentPane.add(lbPrecoRP_);
		
		lbEstoqueRP_ = new JLabel("Quantidade em Estoque:");
		lbEstoqueRP_.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbEstoqueRP_.setBounds(187, 95, 205, 14);
		contentPane.add(lbEstoqueRP_);
		
		painelImagemRP = new JPanel();
		painelImagemRP.setBounds(10, 44, 165, 165);
		contentPane.add(painelImagemRP);
		
		img01 = new JLabel("");
		painelImagemRP.add(img01);
		
		lbPrecoRP = new JLabel("0.00000000");
		lbPrecoRP.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbPrecoRP.setBounds(187, 67, 120, 16);
		contentPane.add(lbPrecoRP);
		
		lbEstoqueRP = new JLabel("0");
		lbEstoqueRP.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbEstoqueRP.setBounds(187, 121, 120, 16);
		contentPane.add(lbEstoqueRP);
		
		lbComunicado = new JLabel("As compras de skins para Counter-Strike Global Offensive estao desativadas.");
		lbComunicado.setHorizontalAlignment(SwingConstants.CENTER);
		lbComunicado.setBounds(10, 221, 778, 16);
		contentPane.add(lbComunicado);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
}
