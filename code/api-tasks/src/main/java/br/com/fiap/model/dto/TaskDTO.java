package br.com.fiap.model.dto;

import br.com.fiap.model.dto.input.UserInput;
import br.com.fiap.model.entity.UserEntity;
import br.com.fiap.model.entity.TaskEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatadeAt;
    private boolean taskFinished;
    private UserDTO userDTO;

    public static TaskDTO toDTO(TaskEntity entity){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(entity.getId());
        taskDTO.setUserDTO(UserDTO.toDTO(entity.getUserEntity()));
        taskDTO.setDescription(entity.getDescription());
        taskDTO.setId(taskDTO.getId());
        taskDTO.setName(entity.getName());
        taskDTO.setCreatedAt(entity.getCreatedAt());
        taskDTO.setUpdatadeAt(entity.getUpdatadeAt());
        return taskDTO;
    }

}
