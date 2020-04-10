package projetM1.graphql.slip.coins;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;


public class CoinsSlipResolver implements GraphQLResolver<CoinsSlip> {
	private final MemberRepository memberRepository;
	
	public CoinsSlipResolver(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}

	public Member member(CoinsSlip coinsSlip) {
		return memberRepository.findById(coinsSlip.getMemberId());
	}
}
