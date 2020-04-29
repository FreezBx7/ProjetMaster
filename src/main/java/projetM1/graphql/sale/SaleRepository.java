package projetM1.graphql.sale;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class SaleRepository {

private final MongoCollection<Document> sales;
	
	public SaleRepository(MongoCollection<Document> sales) {
		
		this.sales = sales;
	}
	
	public Sale findById(int id) {
		Document doc = sales.find(eq("id_sale",id)).first();
		return sales(doc);
	}
	
	public List<Sale> getAllSale(){
		List<Sale> allSales = new ArrayList<>();
		for(Document doc : sales.find()) {
			if(doc.getInteger("id_sale") != null) {
				allSales.add(sales(doc));
			}	
		}
		return allSales;
	}
	
	public List<Sale> getAllSaleBySeller(int id_seller){
		List<Sale> allSales = new ArrayList<>();
		for(Document doc : sales.find()) {
			if(doc.getInteger("id_sale") != null && doc.getInteger("seller") == id_seller) {
				allSales.add(sales(doc));
			}	
		}
		return allSales;
	}
	
	public List<Sale> getAllSaleByBuyer(int id_buyer){
		List<Sale> allSales = new ArrayList<>();
		for(Document doc : sales.find()) {
			if(doc.getInteger("id_sale") != null && doc.getInteger("buyer") == id_buyer) {
				allSales.add(sales(doc));
			}	
		}
		return allSales;
	}
	
	public List<Sale> getAllSaleByDate(String date){
		List<Sale> allSales = new ArrayList<>();
		for(Document doc : sales.find()) {
			if(doc.getInteger("id_sale") != null && doc.getString("date").equals(date)) {
				allSales.add(sales(doc));
			}	
		}
		return allSales;
	}
	
	public void saveSale(Sale sale) {
		Document doc = new Document();
		doc.append("id_sale", sale.getId_sale());
		doc.append("seller", sale.getSeller());
		doc.append("buyer", sale.getBuyer());
		doc.append("date", sale.getDate());
		doc.append("lines", sale.getLines());
		doc.append("price_tot", sale.getPrice_tot());
        sales.insertOne(doc);
	}
	
	@SuppressWarnings("unchecked")
	private Sale sales(Document doc) {
        return new Sale(doc.getInteger("id_sale"),
        				 doc.getInteger("seller"),
        				 doc.getInteger("buyer"),
        				 doc.getString("date"),
        				 (List<Integer>) doc.get("lines"),
        				 doc.getDouble("price_tot"));
    }
}
