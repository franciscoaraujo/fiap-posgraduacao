package br.com.fiap.model.dto.output;

import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserOutput {

    @JsonIgnore
    private Long id;
    private String name;
    private LocalDate createdAt;
    private LocalDate updatadeAt;

    public static UserOutput toDTO(UserEntity userEntity){
        UserOutput userOutput = new UserOutput();
        userOutput.setId(userEntity.getId());
        userOutput.setName(userEntity.getName());
        userOutput.setCreatedAt(userEntity.getCreatedAt());
        userOutput.setId(userEntity.getId());
        userOutput.setUpdatadeAt(userEntity.getUpdatadeAt());
        return userOutput;
    }
}
