package projetM1.graphql.product;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class ProductRepository {

	private final MongoCollection<Document> products;

	public ProductRepository(MongoCollection<Document> products) {
		
		this.products = products;
	}
	public Product findById(int id) {
		Document doc = products.find(eq("id_product",id)).first();
		return products(doc);
	}

	public Product findByBarCode(String barcode) {
		Document doc = products.find(eq("barcode",barcode)).first();
		return products(doc);
	}
	
	public List<Product> getAllProducts(){
		List<Product> allProducts = new ArrayList<>();
		for(Document doc : products.find()) {
			if(doc.getString("barcode") != null) {
				allProducts.add(products(doc));
			}	
		}
		return allProducts;
	}
	
	public void saveProduct(Product product) {
		Document doc = new Document();
		doc.append("id_product", product.getId_product());
		doc.append("barcode", product.getBarcode());
        doc.append("name", product.getName());
        doc.append("selling_price", product.getSelling_price());
        products.insertOne(doc);
	}
	
	private Product products(Document doc) {
        return new Product(doc.getInteger("id_product"),
        				 doc.getString("barcode"),
        				 doc.getString("name"),
        				 doc.getDouble("selling_price"));
    }
}
