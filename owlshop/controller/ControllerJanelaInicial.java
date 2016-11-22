package owlshop.controller;

import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.UIManager;
import owlshop.model.Connections;
import owlshop.view.JanelaInicial;

public class ControllerJanelaInicial {
	
	private JanelaInicial janela;
	private JDialog dialog;
	private Connections conn;
	private ControllerJanelaLogin cntrl;
	
	public ControllerJanelaInicial(String plaf) {
		
		conn = new Connections();
		
		try {
            UIManager.setLookAndFeel(plaf);
        } catch(Exception e) {
            e.printStackTrace();
        }
		janela = new JanelaInicial();
        dialog = new JDialog();
        dialog.setContentPane(this.janela);
        dialog.setSize(455, 165);
        dialog.setVisible(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
		
        Connection conn = this.conn.getConnection();
        
		if(conn == null){
			janela.showMessage("Falha ao tentar conectar com o Banco de Dados!");
			dialog.dispose();
		}else{
			janela.showMessage("Sucesso!!! Espere alguns segundos...");
			cntrl = new ControllerJanelaLogin(this.conn);
			cntrl.abrir("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			dialog.dispose();
		}
		
	}

}
