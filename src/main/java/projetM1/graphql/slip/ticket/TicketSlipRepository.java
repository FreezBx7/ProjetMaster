package projetM1.graphql.slip.ticket;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import projetM1.graphql.price.Price;


public class TicketSlipRepository {
	private final MongoCollection<Document> ticketSlips;

	public TicketSlipRepository(MongoCollection<Document> ticketSlip) {
		
		this.ticketSlips = ticketSlip;
	}
	
	public TicketSlip findByDate(String date) {
		Document doc = ticketSlips.find(eq("date",date)).first();
		return ticketSlip(doc);
	}
	public TicketSlip findById(int id) {
		Document doc = ticketSlips.find(eq("id_ticketSlip",id)).first();
		return ticketSlip(doc);
	}
	
	public List<TicketSlip> getAllTicketSlip(){
		List<TicketSlip> allTicketSlips = new ArrayList<>();
		for(Document doc : ticketSlips.find()) {
			if(doc.getInteger("id_ticketSlip") != null) {
				allTicketSlips.add(ticketSlip(doc));
			}	
		}
		return allTicketSlips;
	}
	
	public void saveTicketSlip(TicketSlip ticketSlip) {
		Document doc = new Document();
		doc.append("id_ticketSlip", ticketSlip.getId_ticketSlip());
		doc.append("fifty", ticketSlip.getFifty());
		doc.append("twenty", ticketSlip.getTwenty());
		doc.append("ten", ticketSlip.getTen());
		doc.append("five", ticketSlip.getFive());
		doc.append("date", ticketSlip.getDate());
		doc.append("total_amount", ticketSlip.getTotal_amount());
		doc.append("memberId", ticketSlip.getMemberId());
		doc.append("num_slip", ticketSlip.getNum_slip());

        ticketSlips.insertOne(doc);
	}
	
	private TicketSlip ticketSlip(Document doc) {
        return new TicketSlip(doc.getInteger("id_ticketSlip"),
		 				 doc.getInteger("fifty"),
						 doc.getInteger("twenty"),
						 doc.getInteger("ten"),
						 doc.getInteger("five"),
						 doc.getString("date"),
        				 doc.getDouble("total_amount"),
        				 doc.getInteger("memberId"),
        				 doc.getString("num_slip"));
    }
}
