package com.enel.enel.apis;

import com.enel.enel.Autowire;
import com.enel.enel.domain.Blog;
import com.enel.enel.domain.User;
import com.enel.enel.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // el unico que tiene permiso de petición
@RestController // tipo de peticion
@RequestMapping("/user") // ruta de acceso

public class UserController {
    @Autowired // instanciar metodo servicio
    private UserService userService;

    @GetMapping("/") //optener usuarios información
    private ResponseEntity<User> consultarUser(@RequestParam("id") int id){
        Optional<User> user=this.userService.consultarUser(id);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

}