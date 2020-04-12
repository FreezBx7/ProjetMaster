package projetM1.graphql.settings;

public class Settings {
	private final int id_settings;
	private final String photo_directory;
	private final boolean cash_register;
	private final boolean scan;
	
	public Settings(int id_settings, String photo_directory, boolean cash_register, boolean scan) {
		super();
		this.id_settings = id_settings;
		this.photo_directory = photo_directory;
		this.cash_register = cash_register;
		this.scan = scan;
	}

	public int getId_settings() {
		return id_settings;
	}

	public String getPhoto_directory() {
		return photo_directory;
	}

	public boolean isCash_register() {
		return cash_register;
	}

	public boolean isScan() {
		return scan;
	}
	
	

}
