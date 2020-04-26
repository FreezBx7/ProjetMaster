package projetM1.graphql.sale;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private final int id_sale;
	private final int id_seller;
	private final int id_buyer;
	private final String date;
	private List<Integer> id_lines = new ArrayList<Integer>();
	private final double price_tot;
	
	public Sale(int id_sale, int id_seller, int id_buyer, String date, List<Integer> id_lines2, double price_tot) {
		super();
		this.id_sale = id_sale;
		this.id_seller = id_seller;
		this.id_buyer = id_buyer;
		this.date = date;
		this.id_lines = id_lines2;
		this.price_tot = price_tot;
	}

	public int getId_sale() {
		return id_sale;
	}

	public int getId_seller() {
		return id_seller;
	}

	public int getId_buyer() {
		return id_buyer;
	}

	public String getDate() {
		return date;
	}

	public List<Integer> getId_lines() {
		return id_lines;
	}

	public double getPrice_tot() {
		return price_tot;
	}
	
	
}
