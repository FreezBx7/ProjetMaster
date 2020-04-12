package projetM1.graphql.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.reduction.Reduction;
import projetM1.graphql.reduction.ReductionRepository;
import projetM1.graphql.settings.Settings;
import projetM1.graphql.settings.SettingsRepository;
import projetM1.graphql.slip.coins.CoinsSlip;
import projetM1.graphql.slip.coins.CoinsSlipRepository;
import projetM1.graphql.slip.ticket.TicketSlip;
import projetM1.graphql.slip.ticket.TicketSlipRepository;
import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Query implements GraphQLRootResolver {
	
	private final TrainingRepository trainingRepository;
	private final MemberRepository memberRepository;
	private final PriceRepository priceRepository;
	private final ProductRepository productRepository;
	private final TicketSlipRepository ticketSlipRepository;
	private final CoinsSlipRepository coinsSlipRepository;
	private final ReductionRepository reductionRepository;
	private final SettingsRepository settingsRepository;

	public Query(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository,
			ProductRepository productRepository,TicketSlipRepository ticketSlipRepository, CoinsSlipRepository coinsSlipRepository,
			ReductionRepository reductionRepository, SettingsRepository settingsRepository) {
		
		this.trainingRepository = trainingRepository;
		this.memberRepository = memberRepository;
		this.priceRepository = priceRepository;
		this.productRepository = productRepository;
		this.ticketSlipRepository = ticketSlipRepository;
		this.coinsSlipRepository = coinsSlipRepository;
		this.reductionRepository = reductionRepository;
		this.settingsRepository = settingsRepository;
	}
	


	public List<Training> allTrainings(){
		return trainingRepository.getAllTrainings();
	}
	
	public Training TrainingById(int id) {
		return trainingRepository.findById(id);
	}
	
	public List<Member> allMembers(){
		return memberRepository.getAllMembers();
	}
	
	public Member MemberById(int id) {
		return memberRepository.findById(id);
	}
	
	public List<Price> allPrices(){
		return priceRepository.getAllPrices();
	}
	
	public Price PriceById(int id) {
		return priceRepository.findById(id);
	}
	
	public List<Product> allProducts(){
		return productRepository.getAllProducts	();
	}
	
	public Product ProductByBarCode(String barcode) {
		return productRepository.findByBarCode(barcode);
	}
	
	public List<TicketSlip> allTicketSlips(){
		return ticketSlipRepository.getAllTicketSlip();
	}
	
	public TicketSlip TicketSlipByDate(String date) {
		return ticketSlipRepository.findByDate(date);
	}
	
	public List<CoinsSlip> allCoinsSlips(){
		return coinsSlipRepository.getAllCoinsSlip();
	}
	
	public CoinsSlip CoinsSlipByDate(String date) {
		return coinsSlipRepository.findByDate(date);
	}
	
	public List<Reduction> allReductions(){
		return reductionRepository.getAllReduction();
	}
	
	public Reduction reductionById(int id) {
		return reductionRepository.findById(id);
	}
	
	public List<Settings> allSettings(){
		return settingsRepository.getAllSettings();
	}

}
