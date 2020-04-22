package projetM1.graphql.provider;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class ProviderRepository {

	private final MongoCollection<Document> providers;

	public ProviderRepository(MongoCollection<Document> providers) {
		
		this.providers = providers;
	}
	
	public Provider findById(int id) {
		Document doc = providers.find(eq("id_provider",id)).first();
		return provider(doc);
	}
	
	public List<Provider> getAllProvider(){
		List<Provider> allProviders = new ArrayList<>();
		for(Document doc : providers.find()) {
			if(doc.getInteger("id_provider") != null) {
				allProviders.add(provider(doc));
			}	
		}
		return allProviders;
	}
	
	public void saveProvider(Provider provider) {
		Document doc = new Document();
		doc.append("id_provider", provider.getId_provider());
        doc.append("name", provider.getName());
        doc.append("address", provider.getAddress());
        doc.append("phone", provider.getPhone());
		doc.append("email", provider.getEmail());
        providers.insertOne(doc);
	}
	
	private Provider provider(Document doc) {
        return new Provider(doc.getInteger("id_provider"),
        				 doc.getString("name"),
        				 doc.getString("address"),
        				 doc.getString("phone"),
        				 doc.getString("email"));
    }
}
