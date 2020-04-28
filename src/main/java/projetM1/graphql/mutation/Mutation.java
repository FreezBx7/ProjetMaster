package projetM1.graphql.mutation;


import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.cashfund.CashFund;
import projetM1.graphql.cashfund.CashFundRepository;
import projetM1.graphql.inventory.Inventory;
import projetM1.graphql.inventory.InventoryRepository;
import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductMap;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.provider.Provider;
import projetM1.graphql.provider.ProviderRepository;
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

public class Mutation implements GraphQLRootResolver {
    
    private final TrainingRepository trainingRepository;
    private final MemberRepository memberRepository;
    private final PriceRepository priceRepository;
	private final ProductRepository productRepository;
	private final TicketSlipRepository ticketSlipRepository;
	private final CoinsSlipRepository coinsSlipRepository;
	private final ReductionRepository reductionRepository;
	private final CashFundRepository cashFundRepository;
	private final ProviderRepository providerRepository;
	private final InventoryRepository inventoryRepository;
	private final SettingsRepository settingsRepository;

    public Mutation(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository,
    		ProductRepository productRepository,TicketSlipRepository ticketSlipRepository,CoinsSlipRepository coinsSlipRepository,
    		ReductionRepository reductionRepository, CashFundRepository cashFundRepository, ProviderRepository providerRepository,
    		InventoryRepository inventoryRepository, SettingsRepository settingsRepository) {
    	this.inventoryRepository = inventoryRepository;
        this.trainingRepository = trainingRepository;
        this.memberRepository = memberRepository;
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.ticketSlipRepository = ticketSlipRepository;
        this.coinsSlipRepository = coinsSlipRepository;
        this.reductionRepository = reductionRepository;
        this.cashFundRepository = cashFundRepository;
        this.providerRepository = providerRepository;
        this.settingsRepository = settingsRepository;
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
    	System.out.println(count);
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
    public Reduction createReduction(String name, boolean active, double rate, List<Integer> id_products) {
    	int count = reductionRepository.getAllReduction().size() + 1;
    	Reduction newReduction = new Reduction(count,name,active,rate,id_products);
    	reductionRepository.saveReduction(newReduction);
    	return newReduction;
    }
    
    public CashFund createCashFund(String date, double sum, int member, int fifty, int twenty, int ten, int five,
			int two, int one, int fiftycents, int twentycents, int tencents, int fivecents, int twocents,
			int onecents) {
    	int count = cashFundRepository.getAllCashFunds().size() + 1;
    	CashFund newCashFund = new CashFund(count, date, sum, member, fifty, twenty, ten, five, two, one, fiftycents, twentycents, tencents, fivecents, twocents, onecents);
    	cashFundRepository.saveCashFund(newCashFund);
    	return newCashFund;
    }
    
    public Provider createProvider(String name, String address, String phone, String email) {
    	int count = providerRepository.getAllProvider().size() + 1;
    	Provider newProvider = new Provider(count, name, address, phone, email);
    	providerRepository.saveProvider(newProvider);
    	return newProvider;
    }
    
    public Inventory createInventory(String date, List<ProductMap> products) {
    	int count = inventoryRepository.getAllInventorys().size() + 1;
    	Inventory newInventory = new Inventory(count,date,products);
    	inventoryRepository.savePInventory(newInventory);
    	return newInventory;
    	
    }
    
    public Settings createSettings(String photo_directory,boolean cash_register, boolean scan) {
    	int count = settingsRepository.getAllSettings().size() + 1;
    	Settings newSettings = new Settings(count,photo_directory,cash_register,scan);
    	settingsRepository.saveSettings(newSettings);
    	return newSettings;
    }
    public Settings updateSettings(int id_settings, String photo_directory,boolean cash_register, boolean scan) {
    	Settings updateSettings = new Settings(id_settings,photo_directory,cash_register,scan);
    	settingsRepository.updateSettings(updateSettings);
    	return updateSettings;
    }
}
