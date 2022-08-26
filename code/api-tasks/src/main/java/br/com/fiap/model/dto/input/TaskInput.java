package br.com.fiap.model.dto.input;

import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.entity.TaskEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskInput {

    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatadeAt;
    private boolean taskFinished;
    private Long idUser;

    public static TaskInput toDTO(TaskEntity taskEntity){
        TaskInput taskInput = new TaskInput();
        taskInput.setTaskFinished(taskEntity.isTaskFinished());
        taskInput.setName(taskEntity.getName());
        taskInput.setDescription(taskEntity.getDescription());
        taskInput.setId(taskEntity.getId());
        taskInput.setCreatedAt(taskEntity.getCreatedAt());
        taskInput.setIdUser(taskEntity.getUserEntity().getId());
        return taskInput;
    }
}
