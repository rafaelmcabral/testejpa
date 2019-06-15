package testejpa.dao.task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class DeleteTask {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		
		Task resultTask = manager.find(Task.class, 1L);
		if (resultTask != null) {
			manager.getTransaction().begin();
			manager.remove(resultTask);
			manager.getTransaction().commit();
			manager.close();
			System.out.println("Task ID " + resultTask.getId() + " excluído com sucesso");
		} else {
			System.out.println("Task não encontrado");
		}
	}
}
