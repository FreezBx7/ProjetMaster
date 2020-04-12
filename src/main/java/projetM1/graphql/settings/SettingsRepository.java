package projetM1.graphql.settings;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import projetM1.graphql.price.Price;
import projetM1.graphql.training.Training;

public class SettingsRepository {
	private final MongoCollection<Document> settings;

	public SettingsRepository(MongoCollection<Document> settings) {
	
		this.settings = settings;
	}
	
	public List<Settings> getAllSettings(){
		List<Settings> allSettings = new ArrayList<>();
		
		for(Document doc : settings.find()) {
			if(doc.getInteger("id_settings") != null) {
				allSettings.add(settings(doc));
			}
			
		}
		return allSettings;
	}
	
	public Settings findById(int id) {
		Document doc = settings.find(eq("id_settings",id)).first();
		return settings(doc);
	}
	
	public void saveSettings(Settings settings) {
		Document doc = new Document();
		doc.append("id_settings", settings.getId_settings());
        doc.append("photo_directory", settings.getPhoto_directory());
        doc.append("cash_register", settings.isCash_register());
        doc.append("scan", settings.isScan());
        this.settings.insertOne(doc);
	}
	public void updateSettings(Settings settings) {
		Document doc = new Document();
		Document doc2 = this.settings.find(eq("id_settings",settings.getId_settings())).first();
		Document updateDoc = new Document();
		doc.append("id_settings", settings.getId_settings());
        doc.append("photo_directory", settings.getPhoto_directory());
        doc.append("cash_register", settings.isCash_register());
        doc.append("scan", settings.isScan());
        
        updateDoc.put("$set", doc);
        this.settings.updateOne(doc2,updateDoc);
	}
	
	private Settings settings(Document doc) {
        return new Settings(doc.getInteger("id_settings"),doc.getString("photo_directory"),doc.getBoolean("cash_register"),doc.getBoolean("scan"));
    }
	
	
}
