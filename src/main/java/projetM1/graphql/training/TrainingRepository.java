package projetM1.graphql.training;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class TrainingRepository {
	
	private final MongoCollection<Document> trainings;
	
	public TrainingRepository(MongoCollection<Document> trainings) {
		this.trainings = trainings;
	}
	
	
	public List<Training> getAllTrainings(){
		List<Training> allTrainings = new ArrayList<>();
		for(Document doc : trainings.find()) {
			allTrainings.add(training(doc));
		}
		return allTrainings;
	}
	
	public void saveTraining(Training training) {
		Document doc = new Document();
		doc.append("id_training", training.getId_training());
        doc.append("name", training.getName());
        trainings.insertOne(doc);
	}
	
	private Training training(Document doc) {
        return new Training(doc.getString("name"));
    }

}
