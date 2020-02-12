package projetM1.graphql.member;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;



public class MemberRepository {
	private final MongoCollection<Document> members;
	
	public MemberRepository(MongoCollection<Document> members) {
		this.members = members;
	}
	
	public Member findById(int id) {
		Document doc = members.find(eq("id_member",id)).first();
		return member(doc);
	}
	
	public List<Member> findByUserId(int priceId){
		List<Member> list = new ArrayList<>();
		for(Document doc : members.find(eq("priceId",priceId))) {
			list.add(member(doc));
		}
		return list;
	}
	
	public List<Member> getAllMembers(){
		List<Member> allMembers = new ArrayList<>();
		for(Document doc : members.find()) {
			if(doc.getInteger("id_member") != null) {
				allMembers.add(member(doc));
			}
			
		}
		return allMembers;
	}
	
	public Member saveMember(Member member) {
		Document doc = new Document();
		doc.append("id_member", member.getId_member());
        doc.append("card", member.getCard());
        doc.append("name", member.getName());
        doc.append("firstName", member.getFirstName());
        doc.append("link_photo", member.getLink_photo());
        doc.append("email", member.getEmail());
        doc.append("price", member.getPriceId());
        doc.append("code", member.getCode());
        doc.append("secret_code", member.getSecret_code());
        doc.append("adherent", member.isAdherent());
        doc.append("active", member.isActive());
        doc.append("administrator", member.isAdministrator());
        doc.append("superAdministrator", member.isSuperAdministrator());
        members.insertOne(doc);
        return new Member(
        		member.getId_member(),
        		member.getCard(),
        		member.getName(),
        		member.getFirstName(),
        		member.getLink_photo(),
        		member.getEmail(),
        		member.getPriceId(),
        		member.getCode(),
        		member.getSecret_code(),
        		member.isAdherent(),
        		member.isActive(),
        		member.isAdministrator(),
        		member.isSuperAdministrator()
        		);
	}
	
	private Member member(Document doc) {
        return new Member(doc.getInteger("id_member"),
        				  doc.getString("card"),
        				  doc.getString("name"),
        				  doc.getString("first_name"),
        				  doc.getString("link_photo"),
        				  doc.getString("email"),
        				  doc.getInteger("price"),
        				  doc.getInteger("code"),
        				  doc.getInteger("secret_code"),
        				  doc.getBoolean("adherent"),
        				  doc.getBoolean("active"),
        				  doc.getBoolean("administrator"),
        				  doc.getBoolean("superAdministrator")
        		);
    }
}
