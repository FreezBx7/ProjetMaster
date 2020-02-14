package projetM1.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.servlet.annotation.WebServlet;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.member.MemberResolver;
import projetM1.graphql.mutation.Mutation;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.query.Query;
import projetM1.graphql.slip.ticket.TicketSlipRepository;
import projetM1.graphql.slip.ticket.TicketSlipResolver;
import projetM1.graphql.training.TrainingRepository;


@SuppressWarnings("resource")
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final TrainingRepository  trainingRepository;
	private static final MemberRepository memberRepository;
	private static final PriceRepository priceRepository;
	private static final ProductRepository productRepository;
	private static final TicketSlipRepository ticketSlipRepository;

	static {
        //Change to `new MongoClient("<host>:<port>")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("projetM1");
        trainingRepository = new TrainingRepository(mongo.getCollection("training"));
        memberRepository = new MemberRepository(mongo.getCollection("member"));
        priceRepository = new PriceRepository(mongo.getCollection("price"));
        productRepository = new ProductRepository(mongo.getCollection("product"));
        ticketSlipRepository = new TicketSlipRepository(mongo.getCollection("ticketSlip"));
        
    }
	
	public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                		new Query(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository),
                		new Mutation(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository),
                		new MemberResolver(priceRepository),
                		new TicketSlipResolver(memberRepository))
                .build()
                .makeExecutableSchema();
    }
}