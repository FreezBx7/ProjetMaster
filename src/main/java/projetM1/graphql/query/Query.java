package projetM1.graphql.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.cashfund.CashFund;
import projetM1.graphql.cashfund.CashFundRepository;
import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.provider.Provider;
import projetM1.graphql.provider.ProviderRepository;
import projetM1.graphql.reduction.Reduction;
import projetM1.graphql.reduction.ReductionRepository;
import projetM1.graphql.sale.LineSale;
import projetM1.graphql.sale.LineSaleRepository;
import projetM1.graphql.sale.Sale;
import projetM1.graphql.sale.SaleRepository;
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
	private final CashFundRepository cashFundRepository;
	private final ProviderRepository providerRepository;
	private final LineSaleRepository lineSaleRepository;
	private final SaleRepository saleRepository;

	public Query(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository,
			ProductRepository productRepository,TicketSlipRepository ticketSlipRepository, CoinsSlipRepository coinsSlipRepository,
			ReductionRepository reductionRepository, CashFundRepository cashFundRepository, ProviderRepository providerRepository,
			LineSaleRepository lineSaleRepository, SaleRepository saleRepository) {
		
		this.trainingRepository = trainingRepository;
		this.memberRepository = memberRepository;
		this.priceRepository = priceRepository;
		this.productRepository = productRepository;
		this.ticketSlipRepository = ticketSlipRepository;
		this.coinsSlipRepository = coinsSlipRepository;
		this.reductionRepository = reductionRepository;
		this.cashFundRepository = cashFundRepository;
		this.providerRepository = providerRepository;
        this.lineSaleRepository = lineSaleRepository;
        this.saleRepository = saleRepository;
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
	
	public List<CashFund> allCashFunds(){
		return cashFundRepository.getAllCashFunds();
	}
	
	public List<CashFund> allCashFundsByMember(int member){
		return cashFundRepository.getAllCashFundsByMember(member);
	}
	
	public CashFund cashFundById(int id) {
		return cashFundRepository.findById(id);
	}
	
	public List<Provider> allProviders(){
		return providerRepository.getAllProvider();
	}
	
	public Provider providerById(int id) {
		return providerRepository.findById(id);
	}

	public List<LineSale> allLineSales(){
		return lineSaleRepository.getAllLineSales();
	}
	
	public LineSale lineSaleById(int id) {
		return lineSaleRepository.findById(id);
	}
	
	public List<Sale> allSale() {
		return saleRepository.getAllSale();
	}
	
	public List<Sale> allSaleBySeller(int id_seller) {
		return saleRepository.getAllSaleBySeller(id_seller);
	}
	
	public List<Sale> allSaleByBuyer(int id_buyer) {
		return saleRepository.getAllSaleByBuyer(id_buyer);
	}
	
	public List<Sale> allSaleByDate(String date) {
		return saleRepository.getAllSaleByDate(date);
	}
	
	public Sale saleById(int id_sale) {
		return saleRepository.findById(id_sale);
	}
}
