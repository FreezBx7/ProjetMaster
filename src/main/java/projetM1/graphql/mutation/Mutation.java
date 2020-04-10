package projetM1.graphql.mutation;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.slip.coins.CoinsSlip;
import projetM1.graphql.slip.coins.CoinsSlipRepository;
import projetM1.graphql.slip.ticket.TicketSlip;
import projetM1.graphql.slip.ticket.TicketSlipRepository;
import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final TrainingRepository trainingRepository;
    private final MemberRepository memberRepository;
    private final PriceRepository priceRepository;
	private final ProductRepository productRepository;
	private final TicketSlipRepository ticketSlipRepository;
	private final CoinsSlipRepository coinsSlipRepository;

    public Mutation(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository,
    		ProductRepository productRepository,TicketSlipRepository ticketSlipRepository,CoinsSlipRepository coinsSlipRepository) {
        this.trainingRepository = trainingRepository;
        this.memberRepository = memberRepository;
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.ticketSlipRepository = ticketSlipRepository;
        this.coinsSlipRepository = coinsSlipRepository;
    }
    
    public Training createTraining(String name) {
    	
    	int count = trainingRepository.getAllTrainings().size() + 1;
        Training newTraining = new Training(count,name);
        trainingRepository.saveTraining(newTraining);
        return newTraining;
    }
    
    public Member createMember(String card, String name, String firstName, String link_photo, String email,
			int price, int code, int secret_code, boolean adherent, boolean active, boolean administrator,
			boolean superAdministrator) {
    	int count = memberRepository.getAllMembers().size() + 1;
    	Member newMember = new Member(count,card,name,firstName,link_photo,email,price,code,secret_code,adherent,active,administrator,superAdministrator);
    	memberRepository.saveMember(newMember);
    	
    	return newMember;
    }
    
    public Price createPrice(String name, double price, boolean active) {
    	int count = priceRepository.getAllPrices().size() + 1;
    	Price newPrice = new Price(count,name,price,active);
    	priceRepository.savePrice(newPrice);
    	return newPrice;
    }
    
    public Product createProduct(String barcode, String name, double selling_price) {
    	int count = productRepository.getAllProducts().size() + 1;
    	Product newProduct = new Product(count,barcode,name,selling_price);
    	productRepository.saveProduct(newProduct);
    	return newProduct;
    }
    
    public TicketSlip createTicketSlip(int fifty,int twenty, int ten, int five,String date, 
			double total_amount, int memberId, String num_slip) {
    	int count = ticketSlipRepository.getAllTicketSlip().size() + 1;
    	TicketSlip newTicketSlip = new TicketSlip(count, fifty, twenty, ten, five, date, total_amount, memberId, num_slip);
    	ticketSlipRepository.saveTicketSlip(newTicketSlip);
    	return newTicketSlip;
    	
    }
    public CoinsSlip createCoinsSlip(int two,int one, int fiftycents,int tencents, int twentycents, int fivecents, int twocents, int onecents, String date, 
			double total_amount, int memberId, String num_slip) {
    	int count = coinsSlipRepository.getAllCoinsSlip().size() + 1;
    	CoinsSlip newCoinsSlip = new CoinsSlip(count, two, one, fiftycents,tencents, twentycents, fivecents, twocents, onecents, date, total_amount, memberId, num_slip);
    	coinsSlipRepository.saveCoinsSlip(newCoinsSlip);
    	return newCoinsSlip;
    	
    }
}
