package projetM1.graphql.product;

public class Product {
	
	private final int id_product;
	private final String barcode;
	private final String name;
	private final Double selling_price;
	
	public Product(int id_product,String barcode, String name, Double selling_price) {
		super();
		this.id_product = id_product;
		this.barcode = barcode;
		this.name = name;
		this.selling_price = selling_price;
	}

	
	
	public int getId_product() {
		return id_product;
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
