package br.com.fiap.service;

import br.com.fiap.model.dto.TaskDTO;
import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.dto.input.TaskInput;
import br.com.fiap.model.dto.output.TaskOutput;
import br.com.fiap.model.entity.TaskEntity;
import br.com.fiap.model.entity.UserEntity;
import br.com.fiap.model.exceptions.FindUserException;
import br.com.fiap.model.repository.TaskRepository;
import br.com.fiap.model.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class TaskService {

    @Autowired
    private TaskRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = false)
    public TaskInput register(TaskInput taskInput) {
        UserEntity userEntity = null;
        if (Objects.nonNull(taskInput.getIdUser())) {
            userEntity = userRepository.findById(taskInput.getIdUser())
                    .orElseThrow(() -> new FindUserException("User not found", taskInput.getIdUser()));
            if (Objects.nonNull(userEntity)) {
                TaskEntity taskpersistence = new TaskEntity();
                taskpersistence.setUserEntity(userEntity);
                taskpersistence.setName(taskInput.getName());
                taskpersistence.setDescription(taskInput.getDescription());
                taskpersistence.setCreatedAt(LocalDate.now());
                taskpersistence.setUpdatadeAt(taskInput.getUpdatadeAt());
                TaskEntity retornoTask = repository.save(taskpersistence);
                return TaskInput.toDTO(retornoTask);
            }
        }
        return new TaskInput();
    }

    @Transactional(readOnly = true)
    public List<TaskOutput> findTaskByIdUser(Long id) {
        List<TaskEntity> taskEntityList = repository.findTaskByIdUser(id).orElseThrow(
                () -> new FindUserException("Task not found", id));
        if (Objects.nonNull(taskEntityList) && !taskEntityList.isEmpty()) {
            return TaskOutput.toDTO(taskEntityList);
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = false)
    public TaskInput update(TaskInput taskInput) {
        TaskEntity taskEntity = null;
        UserEntity userEntity = userRepository
                .findById(taskInput.getIdUser())
                .orElseThrow(() -> new FindUserException("User not found", taskInput.getIdUser()));
        if (Objects.nonNull(taskInput.getId())) {
            taskEntity = repository.findById(taskInput.getId()).orElseThrow(
                    () -> new FindUserException("User not found", taskInput.getId()));
            taskEntity.setUpdatadeAt(LocalDate.now());
            taskEntity.setName(taskInput.getName());
            taskEntity.setDescription(taskInput.getDescription());
            repository.save(taskEntity);
            return taskInput;
        }
        return new TaskInput();
    }


    @Transactional(readOnly = false)
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}
