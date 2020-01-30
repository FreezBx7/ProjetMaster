package projetM1.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final TrainingRepository trainingRepository;

    public Mutation(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
    
    public Training createTraining(String name) {
        Training newTraining = new Training(name);
        trainingRepository.saveTraining(newTraining);
        return newTraining;
    }
}
