package projetM1.graphql.sale;

import java.util.List;

public class Sale {

	private final int id_sale;
	private final int seller;
	private final int buyer;
	private final String date;
	private final List<Integer> lines;
	private final double price_tot;
	
	public Sale(int id_sale, int seller, int buyer, String date, List<Integer> lines, double price_tot) {
		super();
		this.id_sale = id_sale;
		this.seller = seller;
		this.buyer = buyer;
		this.date = date;
		this.lines = lines;
		this.price_tot = price_tot;
	}

	public int getId_sale() {
		return id_sale;
	}

	public int getSeller() {
		return seller;
	}

	public int getBuyer() {
		return buyer;
	}

	public String getDate() {
		return date;
	}

	public List<Integer> getLines() {
		return lines;
	}

	public double getPrice_tot() {
		return price_tot;
	}
	
	
}
