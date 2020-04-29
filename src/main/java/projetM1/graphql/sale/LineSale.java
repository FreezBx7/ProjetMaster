package projetM1.graphql.sale;

public class LineSale {

	private final int id_line;
	private final int id_product;
	private final int quantity;
	private final double sum;
	
	public LineSale(int id_line, int id_product, int quantity, double sum) {
		this.id_line = id_line;
		this.id_product = id_product;
		this.quantity = quantity;
		this.sum = sum;
	}

	public int getId_line() {
		return id_line;
	}

	public int getId_product() {
		return id_product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSum() {
		return sum;
	}
	
}
