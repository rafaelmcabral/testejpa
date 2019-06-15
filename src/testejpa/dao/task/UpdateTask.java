package testejpa.dao.task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class UpdateTask {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		
		Task resultTask = manager.find(Task.class, 2L);
		
		if (resultTask != null) {
			resultTask.setFinalizada(false);
			resultTask.setDataFinalizacao(null);
			resultTask.setDescricao("Estudar JPA update");
			
			manager.getTransaction().begin();
			manager.merge(resultTask);
			manager.getTransaction().commit();
			manager.close();
			System.out.println("Task ID " + resultTask.getId() + " atualizado com sucesso");
		} else {
			System.out.println("Task não encontrado");
		}
	}
}
