package projetM1.graphql.inventory;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import projetM1.graphql.product.ProductMap;

public class InventoryRepository {
	private final MongoCollection<Document> inventorys;

	public InventoryRepository(MongoCollection<Document> inventorys) {
		super();
		this.inventorys = inventorys;
	}
	
	public Inventory findById(int id) {
		Document doc = inventorys.find(eq("id_inventory",id)).first();
		return inventorys(doc);
	}
	public Inventory findByDate(String date) {
		Document doc = inventorys.find(eq("date",date)).first();
		return inventorys(doc);
	}
	
	public List<Inventory> getAllInventorys(){
		List<Inventory> allInventorys = new ArrayList<>();
		for(Document doc : inventorys.find()) {
			if(doc.getInteger("id_invenotry") != null) {
				allInventorys.add(inventorys(doc));
			}	
		}
		return allInventorys;
	}
	
	public void savePInventory(Inventory inventory) {
		Document doc = new Document();
		doc.append("id_inventory", inventory.getId_inventory());
		doc.append("date", inventory.getDate());
        doc.append("products", inventory.getProducts());
        inventorys.insertOne(doc);
	}

	@SuppressWarnings("unchecked")
	private Inventory inventorys(Document doc) {
		return new Inventory(doc.getInteger("id_inventory"),
				 doc.getString("date"),
				 (List<ProductMap>) doc.get("products"));
	}
}
