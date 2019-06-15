package testejpa.dao.task;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class InsertTask {
	public static void main(String[] args) {
		Task task = new Task();
		task.setDescricao("Estudar mais ainda JPA!");
		task.setFinalizada(true);
		task.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Testando JPA e Hibernate");
		System.out.println("ID da Task: " + task.getId());
	}
}
