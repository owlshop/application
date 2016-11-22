package owlshop.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JanelaAdicionarFundos extends JPanel {
	private JTextField address;
	private JLabel lbTitulo;
	private JPanel painelNorte;
	private JPanel painelCentral;
	private JLabel lbTituloCentral;
	private JPanel painelSul;
	public JTextField tfTransacao;
	private JLabel lbTituloCentral2;
	public JButton btConfirmar;
	public JButton btCancelar;

	public JanelaAdicionarFundos() {
		setLayout(new BorderLayout(0, 0));
		
		painelNorte = new JPanel();
		add(painelNorte, BorderLayout.NORTH);
		
		lbTitulo = new JLabel("Adicionar Fundos");
		lbTitulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		painelNorte.add(lbTitulo);
		
		painelCentral = new JPanel();
		add(painelCentral, BorderLayout.CENTER);
		
		lbTituloCentral = new JLabel("Transfira a quantia de Bitcoins desejada para este endereco:");
		painelCentral.add(lbTituloCentral);
		
		address = new JTextField();
		address.setEditable(false);
		address.setText("1JGa6a1ZBNJby4H6G9VKjY5BhYWnjppjUC");
		painelCentral.add(address);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setFont(new Font("SansSerif", Font.PLAIN, 16));
		address.setColumns(34);
		
		lbTituloCentral2 = new JLabel("Coloque o ID da Transacao abaixo:");
		painelCentral.add(lbTituloCentral2);
		
		tfTransacao = new JTextField();
		tfTransacao.setHorizontalAlignment(SwingConstants.CENTER);
		tfTransacao.setFont(new Font("SansSerif", Font.PLAIN, 16));
		painelCentral.add(tfTransacao);
		tfTransacao.setColumns(34);
		
		painelSul = new JPanel();
		add(painelSul, BorderLayout.SOUTH);
		
		btConfirmar = new JButton("Confirmar");
		painelSul.add(btConfirmar);
		
		btCancelar = new JButton("Cancelar");
		painelSul.add(btCancelar);

	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
