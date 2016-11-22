package owlshop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCUsuarioDAO implements UsuarioDAO {
	
	private static final String SELECT = "CONFIDENTIAL";
	private static final String selectUser = "CONFIDENTIAL";
	private static final String Estoque = "CONFIDENTIAL";
	private static final String ComprarSemTradeLink = "CONFIDENTIAL";
	private static final String ComprarComTradeLink = "CONFIDENTIAL";
	private static final String AtualizarCarteira = "CONFIDENTIAL";
	private static final String AtualizarEstoque = "CONFIDENTIAL";
	private static final String SolicitarFundos = "CONFIDENTIAL";
	private ArrayList<Usuario> usuarios;
	private ArrayList<Item> items;
	private Connection conn;
	
	public JDBCUsuarioDAO(Connections conn){
		
		this.conn = conn.getConnection();
		
		usuarios = new ArrayList<Usuario>();
		items = new ArrayList<Item>();
		
		try{
			PreparedStatement stmt = this.conn.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
  
			while(rs.next()){
				this.usuarios.add(new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getFloat("wallet")));
			}
     
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			PreparedStatement stmt = this.conn.prepareStatement(Estoque);
			ResultSet rs = stmt.executeQuery();
  
			while(rs.next()){
				this.items.add(new Item(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), rs.getInt("quantidade")));
			}
     
			rs.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public int realizarLogIn(String username, String password) { //0 = Usuario nao encontrado, 1 = Login com sucesso, 2 = Senha errada
		for(int i = 0; i < usuarios.size(); i++){
			if(username.equals(usuarios.get(i).getUsername())){
				if(password.equals(usuarios.get(i).getPassword())){
					return 1;
				}else{
					return 2;
				}
			}
		}
		return 0;
	}
	
	public Usuario getUsuario(String username) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getUsername().equals(username)){
				return usuarios.get(i);
			}
		}
		return null;
	}
	
	public Usuario selectUsuario(String username) {
		try{
			PreparedStatement stmt = this.conn.prepareStatement(selectUser);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			Usuario u = null;
			
			while(rs.next()){
				u = new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getFloat("wallet"));
			}
			rs.close();
			stmt.close();
			
			return u;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
	}

	@Override
	public void realizarCompra(Usuario user, Item item, String steamTradeLink) {
		try{
			PreparedStatement stmt = conn.prepareStatement(ComprarComTradeLink);
        
    		stmt.setInt(1, user.getId());
    		stmt.setInt(2, item.getId());
    		stmt.setString(3, steamTradeLink);
    
    		stmt.executeUpdate();
    		stmt.close();
    		
    		float newWallet = (user.getWallet() - item.getValor());
    		
    		PreparedStatement stmt2 = conn.prepareStatement(AtualizarCarteira);
    		
    		stmt2.setFloat(1, newWallet);
    		stmt2.setInt(2, user.getId());
    		
    		stmt2.executeUpdate();
    		stmt2.close();
    		
    		PreparedStatement stmt3 = conn.prepareStatement(AtualizarEstoque);
    		
    		item.setQuantidade((item.getQuantidade() - 1));
    		
    		stmt3.setInt(1, item.getQuantidade());
    		stmt3.setInt(2, item.getId());
    		
    		stmt3.executeUpdate();
    		stmt3.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void realizarCompra(Usuario user, Item item) {
		try{
			PreparedStatement stmt = conn.prepareStatement(ComprarSemTradeLink);
        
    		stmt.setInt(1, user.getId());
    		stmt.setInt(2, item.getId());
    
    		stmt.executeUpdate();
    		stmt.close();
    		
    		float newWallet = (user.getWallet() - item.getValor());
    		
    		PreparedStatement stmt2 = conn.prepareStatement(AtualizarCarteira);
    		
    		stmt2.setFloat(1, newWallet);
    		stmt2.setInt(2, user.getId());
    		
    		stmt2.executeUpdate();
    		stmt2.close();
    		
    		PreparedStatement stmt3 = conn.prepareStatement(AtualizarEstoque);
    		
    		item.setQuantidade((item.getQuantidade() - 1));
    		
    		stmt3.setInt(1, item.getQuantidade());
    		stmt3.setInt(2, item.getId());
    		
    		stmt3.executeUpdate();
    		stmt3.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void solicitarFundos(Usuario user, String idTransacao) {
		try{
			PreparedStatement stmt = conn.prepareStatement(SolicitarFundos);
        
			stmt.setInt(1, user.getId());
			stmt.setString(2, idTransacao);
			
			stmt.executeUpdate();
    		stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
