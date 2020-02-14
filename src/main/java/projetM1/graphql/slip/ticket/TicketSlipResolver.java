package projetM1.graphql.slip.ticket;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;


public class TicketSlipResolver implements GraphQLResolver<TicketSlip>{
	private final MemberRepository memberRepository;

	public TicketSlipResolver(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}

	public Member member(TicketSlip ticketSlip) {
		return memberRepository.findById(ticketSlip.getId_ticketSlip());
	}
	
	
	
	
	
}
