package projetM1.graphql.slip.ticket;

import projetM1.graphql.slip.Slip;

public class TicketSlip extends Slip {

	private final int id_ticketSlip;
	private final int fifty;
	private final int twenty;
	private final int ten;
	private final int five;
	

	
	public TicketSlip(int ticketSlipId,int fifty,int twenty, int ten, int five,String date, 
			double total_amount, int memberId, String num_slip) {
		super(date, total_amount, memberId, num_slip);
		this.id_ticketSlip = ticketSlipId;
		this.fifty = fifty;
		this.twenty = twenty;
		this.ten = ten;
		this.five = five;
	}
	public int getId_ticketSlip() {
		return id_ticketSlip;
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
	
	
}
