package br.com.fiap.service;


import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.dto.input.UserInput;
import br.com.fiap.model.dto.output.UserOutput;
import br.com.fiap.model.repository.UserRepository;



import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserService userService;

    @Test
    public void deveCadastrarUsuario(){
        UserInput userInput = new UserInput();
        userInput.setName("fulano");
        userService.register(userInput);
        when(userService.register(any(UserInput.class))).thenReturn(new UserDTO());
    }

    @Test
    public void deveBuscarUmUsuarioPorId(){
        when(userService.findById(1l)).thenReturn(new UserOutput());
    }

    @Test
    public void deveAtualizarUmUsuario(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("fulano");
        userService.update(userDTO);

        when(userService.update(userDTO)).thenReturn(new UserDTO());
    }

}
