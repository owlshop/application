package owlshop.model;

public class Compra {
	
	private int id;
	private Usuario comprador;
	private Item item;
	private String steamTradeLink;
	
	public Compra(Usuario comprador, Item item, String steamTradeLink) {
		this.comprador = comprador;
		this.item = item;
		this.steamTradeLink = steamTradeLink;
	}
	
	public Compra(Usuario comprador, Item item) {
		this.comprador = comprador;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getSteamTradeLink() {
		return steamTradeLink;
	}

	public void setSteamTradeLink(String steamTradeLink) {
		this.steamTradeLink = steamTradeLink;
	}

}
