package owlshop.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JanelaInicial extends JPanel {
	private JLabel lbMessage;

	public JanelaInicial() {
		setLayout(new BorderLayout(0, 0));
		
		lbMessage = new JLabel("Sincronizando dados com o Servidor de Banco de Dados...");
		lbMessage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbMessage);

	}
	
	public void showMessage(String message) {
		lbMessage.setText(message);
	}

}
