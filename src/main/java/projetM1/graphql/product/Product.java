package projetM1.graphql.product;

public class Product {
	
	private final String barcode;
	private final String name;
	private final Double selling_price;
	
	public Product(String barcode, String name, Double selling_price) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.selling_price = selling_price;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public Double getSelling_price() {
		return selling_price;
	}

}
