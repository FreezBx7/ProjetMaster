package projetM1.graphql.member;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.price.Price;
import projetM1.graphql.price.PriceRepository;

public class MemberResolver implements GraphQLResolver<Member> {
	private final PriceRepository priceRepository;

	public MemberResolver(PriceRepository priceRepository) {
		super();
		this.priceRepository = priceRepository;
	}
	
	public Price price(Member member) {
		return priceRepository.findById(member.getPriceId());
	}
}
