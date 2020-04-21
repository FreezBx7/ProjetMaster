package projetM1.graphql.cashfund;

import com.mongodb.client.MongoCollection;

import projetM1.graphql.member.Member;
import projetM1.graphql.price.Price;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class CashFundRepository {
	
	private final MongoCollection<Document> cashfunds;

	public CashFundRepository(MongoCollection<Document> cashfunds) {
		
		this.cashfunds = cashfunds;
	}
	
	public CashFund findById(int id) {
		Document doc = cashfunds.find(eq("id_cash",id)).first();
		return cashfund(doc);
	}
	
	public List<CashFund> getAllCashFunds(){
		List<CashFund> allCashFunds = new ArrayList<>();
		for(Document doc : cashfunds.find()) {
			if(doc.getInteger("id_cash") != null) {
				allCashFunds.add(cashfund(doc));
			}	
		}
		return allCashFunds;
	}
	
	public List<CashFund> getAllCashFundsByMember(int member){
		List<CashFund> allCashFundsByMember = new ArrayList<>();
		for(Document doc : cashfunds.find()) {
			if(doc.getInteger("id_cash") != null && doc.getInteger("member") == member) {
				allCashFundsByMember.add(cashfund(doc));
			}	
		}
		return allCashFundsByMember;
	}
	
	public void saveCashFund(CashFund cash) {
		Document doc = new Document();
		doc.append("id_cash", cash.getId_cash());
        doc.append("date", cash.getDate());
        doc.append("sum", cash.getSum());
        doc.append("member", cash.getMember());
		doc.append("fifty", cash.getFifty());
        doc.append("twenty", cash.getTwenty());
        doc.append("ten", cash.getTen());
        doc.append("five", cash.getFive());
		doc.append("two", cash.getTwo());
        doc.append("one", cash.getOne());
		doc.append("fiftycents", cash.getFiftycents());
        doc.append("twentycents", cash.getTwentycents());
        doc.append("tencents", cash.getTencents());
        doc.append("fivecents", cash.getFivecents());
		doc.append("twocents", cash.getTwocents());
        doc.append("onecents", cash.getOnecents());
        cashfunds.insertOne(doc);
	}
	
	private CashFund cashfund(Document doc) {
        return new CashFund(doc.getInteger("id_cash"),
        				 doc.getString("date"),
        				 doc.getDouble("sum"),
        				 doc.getInteger("member"),
        				 doc.getInteger("fifty"),
        				 doc.getInteger("twenty"),
        				 doc.getInteger("ten"),
        				 doc.getInteger("five"),
        				 doc.getInteger("two"),
        				 doc.getInteger("one"),
        				 doc.getInteger("fiftycents"),
        				 doc.getInteger("twentycents"),
        				 doc.getInteger("tencents"),
        				 doc.getInteger("fivecents"),
        				 doc.getInteger("twocents"),
        				 doc.getInteger("onecents"));
    }
	
	

}
