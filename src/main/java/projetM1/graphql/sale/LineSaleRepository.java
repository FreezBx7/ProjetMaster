package projetM1.graphql.sale;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class LineSaleRepository {

	private final MongoCollection<Document> lineSales;

	public LineSaleRepository(MongoCollection<Document> lineSales) {
		
		this.lineSales = lineSales;
	}
	
	public LineSale findById(int id) {
		Document doc = lineSales.find(eq("id_line",id)).first();
		return lineSales(doc);
	}
	
	public List<LineSale> getAllLineSales(){
		List<LineSale> allLineSales = new ArrayList<>();
		for(Document doc : lineSales.find()) {
			if(doc.getInteger("id_line") != null) {
				allLineSales.add(lineSales(doc));
			}	
		}
		return allLineSales;
	}
	
	public void saveLineSale(LineSale lineSale) {
		Document doc = new Document();
		doc.append("id_line", lineSale.getId_line());
		doc.append("id_product", lineSale.getId_product());
        doc.append("quantity", lineSale.getQuantity());
        doc.append("sum", lineSale.getSum());
        lineSales.insertOne(doc);
	}
	
	private LineSale lineSales(Document doc) {
        return new LineSale(doc.getInteger("id_line"),
        				 doc.getInteger("id_product"),
        				 doc.getInteger("quantity"),
        				 doc.getDouble("sum"));
    }
}
