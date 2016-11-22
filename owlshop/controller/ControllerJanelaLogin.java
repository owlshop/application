package owlshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JDialog;
import javax.swing.UIManager;
import owlshop.model.Connections;
import owlshop.model.JDBCUsuarioDAO;
import owlshop.view.JanelaLogin;

@SuppressWarnings("deprecation")
public class ControllerJanelaLogin implements ActionListener, KeyListener {
	
	private JanelaLogin janela;
	private JDialog dialog;
	private JDBCUsuarioDAO usuario;
	private ControllerJanelaPrincipal cntrl;
	private Connections conn;
	
	public ControllerJanelaLogin(Connections conn) {
		try{
			this.conn = conn;
			usuario = new JDBCUsuarioDAO(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
            iniciarAutenticacao(janela.tfUsername.getText(), janela.tfPassword.getText());
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == janela.btLogin){
         	iniciarAutenticacao(janela.tfUsername.getText(), janela.tfPassword.getText());
        }
	}
	
	public void iniciarAutenticacao(String username, String password) {
		janela.btLogin.setEnabled(false);
		janela.showMessage("Fazendo login...");
		int flag = usuario.realizarLogIn(username, password);
		if(flag == 0){
			janela.showMessage("Username nao encontrado...");
			janela.btLogin.setEnabled(true);
		}
		if(flag == 1){
			janela.showMessage("Logado com Sucesso!");
			cntrl = new ControllerJanelaPrincipal(conn, usuario.getUsuario(username));
			cntrl.abrir("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		if(flag == 2){
			janela.showMessage("Senha incorreta...");
			janela.btLogin.setEnabled(true);
		}
	}
	
	public void abrir(String plaf) {
        try {
            UIManager.setLookAndFeel(plaf);
        } catch(Exception e) {
            e.printStackTrace();
        }
		this.janela = new JanelaLogin();
        this.janela.btLogin.addActionListener(this);
        this.janela.btLogin.addKeyListener(this);
        dialog = new JDialog();
        dialog.setContentPane(this.janela);
        dialog.setSize(470, 300);
        dialog.setVisible(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
	}

}
