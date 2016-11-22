package owlshop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import owlshop.model.Connections;
import owlshop.model.Item;
import owlshop.model.JDBCUsuarioDAO;
import owlshop.model.Usuario;
import owlshop.view.JanelaAdicionarFundos;
import owlshop.view.JanelaPrincipal;

public class ControllerJanelaPrincipal implements ActionListener, ItemListener {
	
	private Usuario user;
	private JDBCUsuarioDAO usuario;
	private JanelaPrincipal janela;
	private JanelaAdicionarFundos janelaAddFundos;
	private ArrayList<Item> items;
	private JDialog dialog;
	
	public ControllerJanelaPrincipal(Connections conn, Usuario user) {
		this.usuario = new JDBCUsuarioDAO(conn);
		this.janela = new JanelaPrincipal();
		this.items = new ArrayList<Item>();
		this.user = user;
		
		items = usuario.getItems();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == janela.btAdicionarFundos){
			abrirJanelaFundos();
        }else if(e.getSource() == janela.btComprarRp){
        	comprarRp(user, (Item) janela.RPComboBox.getSelectedItem());
        }else if(e.getSource() == janelaAddFundos.btConfirmar){
        	adicionarFundos(user, janelaAddFundos.tfTransacao.getText());
        }else if(e.getSource() == janelaAddFundos.btCancelar){
        	dialog.dispose();
        }
	}

	private void comprarRp(Usuario user, Item item) {
		try{
			if(user.getWallet() >= item.getValor()) {
				if(item.getQuantidade() > 0){
					usuario.realizarCompra(user, item);
					items.clear();
					items = usuario.getItems();
					Usuario userTemp = this.user;
					this.user = usuario.selectUsuario(userTemp.getUsername());
					janela.lbWallet.setText(this.user.getWallet() + "   ");
				}else{
					janela.showMessage("O estoque deste item acabou! Espere no minimo uma semama para que possamos repor o estoque.");
				}
			}else{
				janela.showMessage("Saldo da Carteira insuficiente!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void abrirJanelaFundos() {
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
		this.janelaAddFundos = new JanelaAdicionarFundos();
        this.janelaAddFundos.btConfirmar.addActionListener(this);
        this.janelaAddFundos.btCancelar.addActionListener(this);
        dialog = new JDialog();
        dialog.setContentPane(this.janelaAddFundos);
        dialog.setSize(500, 300);
        dialog.setVisible(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
	}
	
	private void adicionarFundos(Usuario user, String Transacao) {
		try{
			usuario.solicitarFundos(user, Transacao);
			janelaAddFundos.showMessage("Pronto! Pode demorar de 1 a 4 dias para que possamos adicionar os fundos a sua carteira. Caso aconteca algum problema entre em contato!");
			dialog.dispose();
		}catch(Exception e){
			e.printStackTrace();
			janelaAddFundos.showMessage("Ocorreu um erro inesperado.");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		janela.lbPrecoRP.setText("" + ((Item) janela.RPComboBox.getSelectedItem()).getValor());
		janela.lbEstoqueRP.setText("" + ((Item) janela.RPComboBox.getSelectedItem()).getQuantidade());
	}
	
	public void abrir(String plaf) {
		try {
            UIManager.setLookAndFeel(plaf);
        } catch(Exception e) {
            e.printStackTrace();
        }
		this.janela = new JanelaPrincipal();
        this.janela.btAdicionarFundos.addActionListener(this);
        this.janela.btLogOut.addActionListener(this);
        this.janela.btComprarRp.addActionListener(this);
        this.janela.RPComboBox.addItemListener(this);
        for(int i = 0; i < items.size(); i++) {
        	this.janela.RPComboBox.addItem(items.get(i));
        }
        this.janela.lbUsername.setText(this.user.getUsername());
        this.janela.lbWallet.setText(this.user.getWallet() + "   ");
        janela.setSize(this.janela.getSize());
        janela.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
	}

}
