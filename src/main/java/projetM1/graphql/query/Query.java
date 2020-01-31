package projetM1.graphql.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Query implements GraphQLRootResolver {
	
	private final TrainingRepository trainingRepository;

	public Query(TrainingRepository trainingRepository) {
		
		this.trainingRepository = trainingRepository;
	}
	
	public List<Training> allTrainings(){
		return trainingRepository.getAllTrainings();
	}
	
	public Training TrainingById(int id) {
		return trainingRepository.findById(id);
	}
	

}
