package projetM1.graphql.training;

import java.util.concurrent.atomic.AtomicInteger;

public class Training {
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id_training;
	private final String name;

	public Training(String name) {
		id_training = count.incrementAndGet(); 
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId_training() {
		return id_training;
	}
	
	
}
