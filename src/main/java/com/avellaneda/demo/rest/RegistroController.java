package com.avellaneda.demo.rest;

import com.avellaneda.demo.domain.User;
import com.avellaneda.demo.dto.UserDto;
import com.avellaneda.demo.model.JwtResponse;
import com.avellaneda.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "${cross.origin}", allowCredentials = "true")
public class RegistroController {

    @Autowired
    UserService userService;

    public RegistroController(UserService userService){
        this.userService = userService;
    }



    @PostMapping({ "/acceso/registrarse" })
    public ResponseEntity<?> registrarUser(@RequestBody UserDto userDto) {
        User user = new User();
        user = User.getUser(userDto);
        user.setLastName("sin registrar");
        userService.registrarUsuario(user);
        return new ResponseEntity<>(new JwtResponse(null, Boolean.TRUE),HttpStatus.OK);
    }


    @RequestMapping(value = "/acceso/ValidarToken" ,  params="token", method = RequestMethod.GET)
    public ResponseEntity<?> validarToken(@RequestParam String token) {
       
    	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Authentication",
				token);

		return new ResponseEntity<JwtResponse>(new JwtResponse(token, Boolean.TRUE),responseHeaders,HttpStatus.OK);
        
    }

    @RequestMapping(value = "/acceso/logOut" ,  params="token", method = RequestMethod.GET)
    public ResponseEntity<?> validarToken() {
       
    
		return new ResponseEntity<>(HttpStatus.OK);
        
    }

}
