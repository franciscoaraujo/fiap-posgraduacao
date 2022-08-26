package br.com.fiap.model.dto.output;

import br.com.fiap.model.entity.TaskEntity;
import br.com.fiap.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class TaskOutput {
    private Long id;
    private String name;
    private LocalDate createdAt;
    private LocalDate updatadeAt;
    private String description;
    private boolean taskFinished ;


    public static List<TaskOutput> toDTO(List<TaskEntity>taskEntityList ){
        List<TaskOutput> taskOutputs = new ArrayList<>();
        for (TaskEntity entity : taskEntityList) {
            TaskOutput taskOutput = new TaskOutput();
            taskOutput.setId(entity.getId());
            taskOutput.setTaskFinished(entity.isTaskFinished());
            taskOutput.setName(entity.getName());
            taskOutput.setDescription(entity.getDescription());
            taskOutput.setUpdatadeAt(entity.getUpdatadeAt());
            taskOutput.setCreatedAt(entity.getCreatedAt());
            taskOutputs.add(taskOutput);
        }
        return taskOutputs;
    }
}
