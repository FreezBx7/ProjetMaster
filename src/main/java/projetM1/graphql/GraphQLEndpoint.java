package projetM1.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.servlet.annotation.WebServlet;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import projetM1.graphql.mutation.Mutation;
import projetM1.graphql.query.Query;
import projetM1.graphql.training.TrainingRepository;


@SuppressWarnings("resource")
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final TrainingRepository  trainingRepository;

	static {
        //Change to `new MongoClient("<host>:<port>")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("projetM1");
        trainingRepository = new TrainingRepository(mongo.getCollection("training"));
    }
	
	public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(trainingRepository),new Mutation(trainingRepository))
                .build()
                .makeExecutableSchema();
    }
}