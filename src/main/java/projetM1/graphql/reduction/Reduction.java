package projetM1.graphql.reduction;

import java.util.List;

import projetM1.graphql.product.Product;

public class Reduction {
	
	private final int id_reduction;
	private final String name;
	private final boolean active;
	private final double rate;
	private final List<Product> products;
	
	public Reduction(int id_reduction, String name, boolean active, double rate, List<Product> products) {
		super();
		this.id_reduction = id_reduction;
		this.name = name;
		this.active = active;
		this.rate = rate;
		this.products = products;
	}

	public int getId_reduction() {
		return id_reduction;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public double getRate() {
		return rate;
	}

	public List<Product> getProducts() {
		return products;
	}

}
