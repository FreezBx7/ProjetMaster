package projetM1.graphql.inventory;

import java.util.List;

import projetM1.graphql.product.ProductMap;

public class Inventory {
	private final int id_inventory;
	private final String date;
	private final List<ProductMap> products;
	
	
	public Inventory(int id_inventory, String date, List<ProductMap> products) {
		super();
		this.id_inventory = id_inventory;
		this.date = date;
		this.products = products;
	}
	
	
	public int getId_inventory() {
		return id_inventory;
	}
	public String getDate() {
		return date;
	}
	public List<ProductMap> getProducts() {
		return products;
	}
	
	
}
