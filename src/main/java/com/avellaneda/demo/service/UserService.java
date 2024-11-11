package com.avellaneda.demo.service;

import com.avellaneda.demo.domain.User;
import com.avellaneda.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    

    @Bean
    public PasswordEncoder getEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    

    
    public void registrarUsuario(User user){
    	System.out.println("Se persiste " + user.toString());
    	user.setPassword(getEncoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    public void actualizarUser(User user){

    }



}
