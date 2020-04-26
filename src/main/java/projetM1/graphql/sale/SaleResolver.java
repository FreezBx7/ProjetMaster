package projetM1.graphql.sale;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.member.Member;
import projetM1.graphql.member.MemberRepository;

public class SaleResolver implements GraphQLResolver<Sale>{

	private final MemberRepository memberRepository;
	private final LineSaleRepository lineSaleRepository;
	
	public SaleResolver(MemberRepository memberRepository, LineSaleRepository lineSaleRepository) {
		super();
		this.memberRepository = memberRepository;
		this.lineSaleRepository = lineSaleRepository;
	}

	public Member seller(Sale sale) {
		return memberRepository.findById(sale.getId_sale());
	}
	
	public Member buyer(Sale sale) {
		return memberRepository.findById(sale.getId_buyer());
	}
	
	public List<LineSale> lines(Sale sale) {
		List<LineSale> listLine = new ArrayList<LineSale>();
		for (int idLine: sale.getId_lines()) {
			listLine.add(lineSaleRepository.findById(idLine));
		}
		return listLine;
	}
}
