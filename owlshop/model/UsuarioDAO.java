package owlshop.model;

public interface UsuarioDAO {
	
	public int realizarLogIn(String username, String password);
	public void realizarCompra(Usuario user, Item item, String steamTradeLink);
	public void realizarCompra(Usuario user, Item item);
	public void solicitarFundos(Usuario user, String idTransacao);
	public Usuario getUsuario(String username);

}
