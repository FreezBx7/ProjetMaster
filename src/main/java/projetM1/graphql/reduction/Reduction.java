package projetM1.graphql.reduction;

import java.util.ArrayList;
import java.util.List;


public class Reduction {
	
	private final int id_reduction;
	private final String name;
	private final boolean active;
	private final double rate;
	private List<Integer> id_products = new ArrayList<Integer>();
	
	public Reduction(int id_reduction, String name, boolean active, double rate, List<Integer> id_products2) {
		super();
		this.id_reduction = id_reduction;
		this.name = name;
		this.active = active;
		this.rate = rate;
		this.id_products = id_products2;
	}
	
	

	public List<Integer> getId_products() {
		return id_products;
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


}
