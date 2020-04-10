package projetM1.graphql.training;

//import java.util.concurrent.atomic.AtomicInteger;

public class Training {
	//private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id_training;
	private final String name;

	public Training(int id_training,String name) {
		this.id_training = id_training; 
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public int getId_training() {
		return id_training;
	}
	
	
}
