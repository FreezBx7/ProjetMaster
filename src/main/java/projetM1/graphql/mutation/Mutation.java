package projetM1.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;
import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;
import projetM1.graphql.training.Training;
import projetM1.graphql.training.TrainingRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final TrainingRepository trainingRepository;
    private final MemberRepository memberRepository;
    private final PriceRepository priceRepository;

    public Mutation(TrainingRepository trainingRepository,MemberRepository memberRepository,PriceRepository priceRepository) {
        this.trainingRepository = trainingRepository;
        this.memberRepository = memberRepository;
        this.priceRepository = priceRepository;
    }
    
    public Training createTraining(String name) {
        Training newTraining = new Training(name);
        trainingRepository.saveTraining(newTraining);
        return newTraining;
    }
    
    public Member createMember(String card, String name, String firstName, String link_photo, String email,
			int price, int code, int secret_code, boolean adherent, boolean active, boolean administrator,
			boolean superAdministrator) {
    	Member newMember = new Member(card,name,firstName,link_photo,email,price,code,secret_code,adherent,active,administrator,superAdministrator);
    	memberRepository.saveMember(newMember);
    	return newMember;
    }
    
    public Price createPrice(String name, double price, boolean active) {
    	Price newPrice = new Price(name,price,active);
    	priceRepository.savePrice(newPrice);
    	return newPrice;
    }
}
