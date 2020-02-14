package projetM1.graphql.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;
import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Query implements GraphQLRootResolver {
	
	private final TrainingRepository trainingRepository;
	private final MemberRepository memberRepository;
	private final PriceRepository priceRepository;
	private final ProductRepository productRepository;

	public Query(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository,
			ProductRepository productRepository) {
		
		this.trainingRepository = trainingRepository;
		this.memberRepository = memberRepository;
		this.priceRepository = priceRepository;
		this.productRepository = productRepository;
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
	

}
