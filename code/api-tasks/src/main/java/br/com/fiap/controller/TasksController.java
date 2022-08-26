package br.com.fiap.controller;


import br.com.fiap.model.dto.MessageResponseDTO;
import br.com.fiap.model.dto.TaskDTO;
import br.com.fiap.model.dto.input.TaskInput;
import br.com.fiap.model.dto.output.TaskOutput;
import br.com.fiap.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskInput> create(@RequestBody TaskInput taskDTO){
        return ResponseEntity.ok().body(taskService.register(taskDTO));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<TaskInput> update(@RequestBody TaskInput taskInput){
        return ResponseEntity.ok().body(taskService.update(taskInput));
    }

    @GetMapping("/findbyuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TaskOutput>> findTaskByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.findTaskByIdUser(id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        taskService.deleteTask(id);
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage("Task Deleted Success: " + id);
        return ResponseEntity.ok().body(messageResponseDTO);
    }
}
