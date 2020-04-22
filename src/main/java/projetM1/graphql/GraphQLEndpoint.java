package projetM1.graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import projetM1.graphql.cashfund.CashFundRepository;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.member.MemberResolver;
import projetM1.graphql.mutation.Mutation;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.provider.ProviderRepository;
import projetM1.graphql.query.Query;
import projetM1.graphql.reduction.ReductionRepository;
import projetM1.graphql.reduction.ReductionResolver;
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
	private static final CashFundRepository cashFundRepository;
	private static final ProviderRepository providerRepository;
	
	
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
        cashFundRepository = new CashFundRepository(mongo.getCollection("cashFund"));
        providerRepository = new ProviderRepository(mongo.getCollection("provider"));
    }
	
	public GraphQLEndpoint() {
        super(buildSchema());
     
	}

    private static GraphQLSchema buildSchema() {
    	
    	
        
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                		new Query(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository,coinsSlipRepository,reductionRepository,cashFundRepository,providerRepository),
                		new Mutation(trainingRepository,memberRepository,priceRepository,productRepository,ticketSlipRepository,coinsSlipRepository,reductionRepository,cashFundRepository,providerRepository),
                		new MemberResolver(priceRepository),
                		new TicketSlipResolver(memberRepository),
                		new CoinsSlipResolver(memberRepository),
                		new ReductionResolver(productRepository))
                .build()
                .makeExecutableSchema();
        
        

    }
    

    




}