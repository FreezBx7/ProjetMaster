package projetM1.graphql.slip;

public class Slip {
	private final String date;
	private final double total_amount;
	private final int memberId;
	private final String num_slip;
	
	public Slip(String date, double total_amount, int memberId, String num_slip) {
		
		this.date = date;
		this.total_amount = total_amount;
		this.memberId = memberId;
		this.num_slip = num_slip;
	}

	public String getDate() {
		return date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getNum_slip() {
		return num_slip;
	}
	
	
	
	
}
