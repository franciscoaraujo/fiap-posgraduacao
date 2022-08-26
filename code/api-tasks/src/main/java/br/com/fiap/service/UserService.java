package br.com.fiap.service;

import br.com.fiap.model.dto.TaskDTO;
import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.dto.input.UserInput;
import br.com.fiap.model.dto.output.UserOutput;
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
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = false)
    public UserDTO register(UserInput user){
        UserEntity userRegister = userRepository.save(UserInput.toEntity(user));
        return UserDTO.toDTO(userRegister);
    }

    @Transactional(readOnly = false)
    public UserDTO update(UserDTO user){
        UserEntity userEntity = null;
        if(Objects.nonNull(user.getId())){
            userEntity = userRepository.findById(user.getId()).orElseThrow(
                    ()-> new FindUserException("User not found", user.getId()));
            userEntity.setUpdatadeAt(LocalDate.now());
            userEntity.setName(userEntity.getName());
            userRepository.save(userEntity);
            return UserDTO.toDTO(userEntity);
        }
        return new UserDTO();
    }

    @Transactional(readOnly = true)
    public UserOutput findById(Long id){
        return UserOutput.toDTO(userRepository.findById(id).orElseThrow(
                ()-> new FindUserException("User not found", id)));
    }

    public void deletUserDTO(Long id){
        List<TaskEntity> taskEntity =  taskRepository.findTaskByIdUser(id).get();
        for (TaskEntity unitTask : taskEntity){
            taskRepository.delete(unitTask);
        }
        userRepository.deleteById(id);
    }

}
