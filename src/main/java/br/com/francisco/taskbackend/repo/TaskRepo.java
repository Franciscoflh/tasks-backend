package br.com.francisco.taskbackend.repo;

import br.com.francisco.taskbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
