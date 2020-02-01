package projetM1.graphql.price;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;



public class PriceRepository {
	
	private final MongoCollection<Document> prices;

	public PriceRepository(MongoCollection<Document> prices) {
		
		this.prices = prices;
	}

	public Price findById(int id) {
		Document doc = prices.find(eq("id_price",id)).first();
		return price(doc);
	}
	
	public List<Price> getAllPrices(){
		List<Price> allPrices = new ArrayList<>();
		for(Document doc : prices.find()) {
			allPrices.add(price(doc));
		}
		return allPrices;
	}
	
	public void savePrice(Price price) {
		Document doc = new Document();
		doc.append("id_price", price.getId_price());
        doc.append("name", price.getName());
        doc.append("price", price.getPrice());
        doc.append("active", price.isActive());
        prices.insertOne(doc);
	}
	
	private Price price(Document doc) {
        return new Price(doc.getString("name"),
        				 doc.getDouble("price"),
        				 doc.getBoolean("active"));
    }
	
}
