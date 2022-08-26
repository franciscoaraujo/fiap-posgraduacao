package br.com.fiap.model.dto.input;

import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInput {

    @JsonIgnore
    private Long id;
    private String name;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatadeAt;

    public static UserEntity toEntity(UserInput userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setCreatedAt(LocalDate.now());
        userEntity.setUpdatadeAt(userDTO.getUpdatadeAt());
        return userEntity;
    }
}
