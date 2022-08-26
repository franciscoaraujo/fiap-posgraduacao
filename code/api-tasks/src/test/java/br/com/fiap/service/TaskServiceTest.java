package br.com.fiap.service;

import br.com.fiap.model.dto.input.TaskInput;
import br.com.fiap.model.dto.input.UserInput;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private TaskService taskService;

    private UserInput userInput;
    private TaskInput taskInput;

    @Before
    public void init() {
        userInput = new UserInput();
        userInput.setId(1l);
        taskInput = new TaskInput();
        taskInput.setIdUser(userInput.getId());
    }

    @Test
    public void deveCastrarUmaTask() {
        when(taskService.register(taskInput)).thenReturn(taskInput);
    }

    @Test
    public void deveBuscarTasksPorIdUsuario() {
        when(taskService.findTaskByIdUser(taskInput.getId())).thenReturn(new ArrayList<>());
    }

    @Test
    public void deveFazerUpdateDeTarefa(){
        when(taskService.update(taskInput)).thenReturn(taskInput);
    }
   
}
