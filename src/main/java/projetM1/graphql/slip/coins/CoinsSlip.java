package projetM1.graphql.slip.coins;

import projetM1.graphql.slip.Slip;

public class CoinsSlip extends Slip {
	
	private final int two;
	private final int one;
	private final int fiftycents;
	private final int twentycents;
	private final int tencents;
	private final int fivecents;
	private final int twocents;
	private final int onecents;
	
	
	
	
	public CoinsSlip(String date, double total_amount, int memberId, String num_slip, int two, int one, int fiftycents,
			int twentycents, int tencents, int fivecents, int twocents, int onecents) {
		super(date, total_amount, memberId, num_slip);
		this.two = two;
		this.one = one;
		this.fiftycents = fiftycents;
		this.twentycents = twentycents;
		this.tencents = tencents;
		this.fivecents = fivecents;
		this.twocents = twocents;
		this.onecents = onecents;
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
