package projetM1.graphql.member;

import java.util.concurrent.atomic.AtomicInteger;

import projetM1.graphql.price.Price;

public class Member {
	
	//private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id_member;
	private final String card;
	private final String name;
	private final String firstName;
	private final String link_photo;
	private final String email;
	private final int priceId;
	private final int code;
	private final int secret_code;
	private final boolean adherent;
	private final boolean active;
	private final boolean administrator;
	private final boolean superAdministrator;
	
	public Member(int id,String card, String name, String firstName, String link_photo, String email,
			int price, int code, int secret_code, boolean adherent, boolean active, boolean administrator,
			boolean superAdministrator) {
		super();
		this.id_member = id;
		this.card = card;
		this.name = name;
		this.firstName = firstName;
		this.link_photo = link_photo;
		this.email = email;
		this.priceId = price;
		this.code = code;
		this.secret_code = secret_code;
		this.adherent = adherent;
		this.active = active;
		this.administrator = administrator;
		this.superAdministrator = superAdministrator;
	}

	public int getId_member() {
		return id_member;
	}

	public String getCard() {
		return card;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLink_photo() {
		return link_photo;
	}

	public String getEmail() {
		return email;
	}

	public int getPriceId() {
		return priceId;
	}

	public int getCode() {
		return code;
	}

	public int getSecret_code() {
		return secret_code;
	}

	public boolean isAdherent() {
		return adherent;
	}

	public boolean isActive() {
		return active;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public boolean isSuperAdministrator() {
		return superAdministrator;
	}
	
	
	
	

}
