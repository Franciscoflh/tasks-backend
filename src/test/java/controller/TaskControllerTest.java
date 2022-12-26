package controller;

import br.com.francisco.taskbackend.controller.TaskController;
import br.com.francisco.taskbackend.model.Task;
import br.com.francisco.taskbackend.repo.TaskRepo;
import br.com.francisco.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;


public class TaskControllerTest {

    @Mock
    private final TaskRepo taskRepo;
    @InjectMocks
    private final TaskController taskController;

    public TaskControllerTest() {
        taskRepo = null;
        taskController = null;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveTaskWithoutDescription(){
        Task task = new Task();
        LocalDate localDateTime = LocalDate.now();
        task.setDueDate(localDateTime);

        try{
            taskController.save(task);
        }catch(ValidationException validationException){
            Assert.assertEquals("Fill the task description", validationException.getMessage());
        }

    }

    @Test
    public void shouldNotSaveTaskWithoutDDate(){
        Task task = new Task();
        task.setTask("Test");

        try{
            taskController.save(task);
        }catch(ValidationException validationException){
            Assert.assertEquals("Fill the due date", validationException.getMessage());
        }

    }

    @Test
    public void shouldNotSaveTaskWithPasDate(){
        Task task = new Task();
        task.setTask("Test");
        LocalDate localDateTime = LocalDate.of(2021, 12, 11);
        task.setDueDate(localDateTime);

        try{
            taskController.save(task);
        }catch(ValidationException validationException){
            Assert.assertEquals("Due date must not be in past", validationException.getMessage());
        }
    }

    @Test
    public void shouldSaveTaskSuccessful() throws ValidationException{
        Task task = new Task();
        task.setTask("Test");
        LocalDate localDateTime = LocalDate.now();
        task.setDueDate(localDateTime);

        taskController.save(task);
        Mockito.verify(taskRepo, Mockito.times(1)).save(task);
    }
}
