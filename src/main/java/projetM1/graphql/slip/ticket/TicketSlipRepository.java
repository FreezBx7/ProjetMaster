package projetM1.graphql.slip.ticket;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class TicketSlipRepository {
	private final MongoCollection<Document> ticketSlip;

	public TicketSlipRepository(MongoCollection<Document> ticketSlip) {
		
		this.ticketSlip = ticketSlip;
	}
	
	
}
