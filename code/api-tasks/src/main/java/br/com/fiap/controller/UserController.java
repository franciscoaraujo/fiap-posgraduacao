package br.com.fiap.controller;


import br.com.fiap.model.dto.MessageResponseDTO;
import br.com.fiap.model.dto.TaskDTO;
import br.com.fiap.model.dto.UserDTO;
import br.com.fiap.model.dto.input.UserInput;
import br.com.fiap.model.dto.output.UserOutput;
import br.com.fiap.model.entity.UserEntity;
import br.com.fiap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody UserInput user){
        return ResponseEntity.ok().body( userService.register(user));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody  UserDTO user){
        return ResponseEntity.ok().body(userService.update(user));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserOutput> findUser(@PathVariable Long id){
        return ResponseEntity.ok().body( ((userService.findById(id))));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable Long id){
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        userService.deletUserDTO(id);
        messageResponseDTO.setMessage("User successfully deleted:" + id);
        return ResponseEntity.ok().body(messageResponseDTO);
    }
}
