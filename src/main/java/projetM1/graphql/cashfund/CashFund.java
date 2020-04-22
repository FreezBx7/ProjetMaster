package projetM1.graphql.cashfund;

import projetM1.graphql.member.Member;

public class CashFund {
	
	private final int id_cash;
	private final String date;
	private final double sum;
	private final int member;
	private final int fifty;
	private final int twenty;
	private final int ten;
	private final int five;
	private final int two;
	private final int one;
	private final int fiftycents;
	private final int twentycents;
	private final int tencents;
	private final int fivecents;
	private final int twocents;
	private final int onecents;
	
	public CashFund(int id_cash, String date, double sum, int member, int fifty, int twenty, int ten, int five,
			int two, int one, int fiftycents, int twentycents, int tencents, int fivecents, int twocents,
			int onecents) {
		
		this.id_cash = id_cash;
		this.date = date;
		this.sum = sum;
		this.member = member;
		this.fifty = fifty;
		this.twenty = twenty;
		this.ten = ten;
		this.five = five;
		this.two = two;
		this.one = one;
		this.fiftycents = fiftycents;
		this.twentycents = twentycents;
		this.tencents = tencents;
		this.fivecents = fivecents;
		this.twocents = twocents;
		this.onecents = onecents;
	}

	public int getId_cash() {
		return id_cash;
	}
	
	public String getDate() {
		return date;
	}
	
	public double getSum() {
		return sum;
	}
	
	public int getMember() {
		return member;
	}
	
	public int getFifty() {
		return fifty;
	}
	
	public int getTwenty() {
		return twenty;
	}
	
	public int getTen() {
		return ten;
	}
	
	public int getFive() {
		return five;
	}
	
	public int getTwo() {
		return two;
	}
	
	public int getOne() {
		return one;
	}
	
	public int getFiftycents() {
		return fiftycents;
	}
	
	public int getTwentycents() {
		return twentycents;
	}
	
	public int getTencents() {
		return tencents;
	}
	
	public int getFivecents() {
		return fivecents;
	}
	
	public int getTwocents() {
		return twocents;
	}
	
	public int getOnecents() {
		return onecents;
	}
	
	
	

}
