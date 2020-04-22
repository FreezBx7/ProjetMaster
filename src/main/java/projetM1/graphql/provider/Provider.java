package projetM1.graphql.provider;

public class Provider {

	private final int id_provider;
	private final String name;
	private final String address;
	private final String phone;
	private final String email;
	
	public Provider(int id_provider, String name, String address, String phone, String email) {
		
		this.id_provider = id_provider;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getId_provider() {
		return id_provider;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
}
