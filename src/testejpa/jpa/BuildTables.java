package testejpa.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuildTables {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		factory.close();
	}
}
