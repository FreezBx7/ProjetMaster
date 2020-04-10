package projetM1.graphql.reduction;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import projetM1.graphql.product.Product;

public class ReductionRepository {

	private final MongoCollection<Document> reductions;

	public ReductionRepository(MongoCollection<Document> reductions) {
		
		this.reductions = reductions;
	}
	
	private Reduction reductions(Document doc) {
        return new Reduction(doc.getInteger("id_reduction"),
        				 doc.getString("name"),
        				 doc.getBoolean("active"),
        				 doc.getDouble("rate"),
        				 doc.get("products"));
    }
}
