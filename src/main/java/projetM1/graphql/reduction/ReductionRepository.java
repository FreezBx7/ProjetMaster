package projetM1.graphql.reduction;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;




public class ReductionRepository {

	private final MongoCollection<Document> reductions;

	public ReductionRepository(MongoCollection<Document> reductions) {
		
		this.reductions = reductions;
	}
	
	public Reduction findById(int id) {
		Document doc = reductions.find(eq("id_reduction",id)).first();
		return reductions(doc);
	}
	
	public List<Reduction> getAllReduction(){
		List<Reduction> allReductions = new ArrayList<>();
		for(Document doc : reductions.find()) {
			if(doc.getInteger("id_reduction") != null) {
				allReductions.add(reductions(doc));
			}	
		}
		return allReductions;
	}
	
	public void saveReduction(Reduction reduction) {
		Document doc = new Document();
		doc.append("id_reduction", reduction.getId_reduction());
		doc.append("name", reduction.getName());
        doc.append("active", reduction.isActive());
        doc.append("rate", reduction.getRate());
        doc.append("products", reduction.getId_products());
        reductions.insertOne(doc);
	}
	
	@SuppressWarnings("unchecked")
	private Reduction reductions(Document doc) {
        return new Reduction(doc.getInteger("id_reduction"),
        				 doc.getString("name"),
        				 doc.getBoolean("active"),
        				 doc.getDouble("rate"),
        				 (List<Integer>) doc.get("products"));
    }
}
