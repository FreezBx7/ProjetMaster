package projetM1.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.GraphQLServletListener;
import graphql.servlet.SimpleGraphQLServlet;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.member.MemberResolver;
import projetM1.graphql.mutation.Mutation;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.query.Query;
import projetM1.graphql.reduction.ReductionRepository;
import projetM1.graphql.reduction.ReductionResolver;
import projetM1.graphql.settings.SettingsRepository;
import projetM1.graphql.slip.coins.CoinsSlipRepository;
import projetM1.graphql.slip.coins.CoinsSlipResolver;
import projetM1.graphql.slip.ticket.TicketSlipRepository;
import projetM1.graphql.slip.ticket.TicketSlipResolver;
import projetM1.graphql.training.TrainingRepository;


@SuppressWarnings("resource")
@WebServlet(name = "GraphQLEndpoint", urlPatterns = {"/graphql/*"}, loadOnStartup = 1)
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
	private static final CoinsSlipRepository coinsSlipRepository;
	private static final ReductionRepository reductionRepository;
	private static final SettingsRepository settingsRepository;
	
	
	static {
        //Change to `new MongoClient("<host>:<port>")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("projetM1");
        trainingRepository = new TrainingRepository(mongo.getCollection("training"));
        memberRepository = new MemberRepository(mongo.getCollection("member"));
        priceRepository = new PriceRepository(mongo.getCollection("price"));
        productRepository = new ProductRepository(mongo.getCollection("product"));
        ticketSlipRepository = new TicketSlipRepository(mongo.getCollection("ticketSlip"));
        coinsSlipRepository = new CoinsSlipRepository(mongo.getCollection("coinsSlip"));
        reductionRepository = new ReductionRepository(mongo.getCollection("reduction"));
        settingsRepository = new SettingsRepository(mongo.getCollection("settings"));
        
    }
	
	public GraphQLEndpoint() {
        super(buildSchema());
     
	}

    private static GraphQLSchema buildSchema() {
    	
    	
        
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                		new Query(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository,coinsSlipRepository,reductionRepository,settingsRepository),
                		new Mutation(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository,coinsSlipRepository,reductionRepository,settingsRepository),
                		new MemberResolver(priceRepository),
                		new TicketSlipResolver(memberRepository),
                		new CoinsSlipResolver(memberRepository),
                		new ReductionResolver(productRepository))
                .build()
                .makeExecutableSchema();
        
        

    }
    

    




}