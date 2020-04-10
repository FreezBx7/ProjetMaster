package projetM1.graphql.slip.coins;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class CoinsSlipRepository {
	private final MongoCollection<Document> coinsSlips;
	
	

	public CoinsSlipRepository(MongoCollection<Document> coinsSlips) {
	
		this.coinsSlips = coinsSlips;
	}

	public CoinsSlip findByDate(String date) {
		Document doc = coinsSlips.find(eq("date",date)).first();
		return coinsSlip(doc);
	}
	public CoinsSlip findById(int id) {
		Document doc = coinsSlips.find(eq("id_coinsSlip",id)).first();
		return coinsSlip(doc);
	}
	
	public List<CoinsSlip> getAllCoinsSlip(){
		List<CoinsSlip> allCoinsSlips = new ArrayList<>();
		for(Document doc : coinsSlips.find()) {
			if(doc.getInteger("id_coinsSlip") != null) {
				allCoinsSlips.add(coinsSlip(doc));
			}	
		}
		return allCoinsSlips;
	}
	
	
	public void saveCoinsSlip(CoinsSlip coinsSlip) {
		Document doc = new Document();
		doc.append("id_coinsSlip", coinsSlip.getId_coinsSlip());
		doc.append("two", coinsSlip.getTwo());
		doc.append("one", coinsSlip.getOne());
		doc.append("fiftycents", coinsSlip.getFiftycents());
		doc.append("twentycents", coinsSlip.getTwentycents());
		doc.append("tencents", coinsSlip.getTencents());
		doc.append("fivecents", coinsSlip.getFivecents());
		doc.append("twocents", coinsSlip.getTwocents());
		doc.append("onecents", coinsSlip.getOnecents());
		doc.append("date", coinsSlip.getDate());
		doc.append("total_amount", coinsSlip.getTotal_amount());
		doc.append("memberId", coinsSlip.getMemberId());
		doc.append("num_slip", coinsSlip.getNum_slip());

        coinsSlips.insertOne(doc);
	}
	
	private CoinsSlip coinsSlip(Document doc) {
        return new CoinsSlip(doc.getInteger("id_coinsSlip"),
		 				 doc.getInteger("two"),
						 doc.getInteger("one"),
						 doc.getInteger("fiftycents"),
						 doc.getInteger("twentycents"),
						 doc.getInteger("tencents"),
						 doc.getInteger("fivecents"),
						 doc.getInteger("twocents"),
						 doc.getInteger("onecents"),
						 doc.getString("date"),
        				 doc.getDouble("total_amount"),
        				 doc.getInteger("memberId"),
        				 doc.getString("num_slip"));
    }
	
	
}
