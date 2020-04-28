package projetM1.graphql.product;

public class ProductMap {
	private final int id_productMap;
	private final Product product;
	private final int quantity;
	
	public ProductMap(int id_productMap, Product product, int quantity) {
		super();
		this.id_productMap = id_productMap;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId_productMap() {
		return id_productMap;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
