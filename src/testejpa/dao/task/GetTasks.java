package testejpa.dao.task;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class GetTasks {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();
		
		List<Task> tasks = manager.createQuery("select t from Task as t where t.finalizada = true").getResultList();
		
		for (Task task : tasks) {
			System.out.println(task.getId() + "\t" + task.getDescricao() + "\t" + task.isFinalizada() + "\t" + task.getDataFinalizacao().getTime());
		}
		
		manager.close();
	}
}
