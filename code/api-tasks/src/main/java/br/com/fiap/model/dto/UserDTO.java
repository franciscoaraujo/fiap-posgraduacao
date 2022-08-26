package br.com.fiap.model.dto;

import br.com.fiap.model.dto.input.TaskInput;
import br.com.fiap.model.entity.UserEntity;
import br.com.fiap.model.entity.TaskEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    @JsonIgnore
    private Long id;
    private String name;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatadeAt;

    public static UserDTO toDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setCreatedAt(userEntity.getCreatedAt());
        userDTO.setId(userEntity.getId());
        userDTO.setUpdatadeAt(userEntity.getUpdatadeAt());
        userDTO.setPassword(userEntity.getPassword());
        return userDTO;
    }
}
