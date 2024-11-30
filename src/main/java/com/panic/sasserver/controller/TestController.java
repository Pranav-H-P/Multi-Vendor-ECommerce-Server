package com.panic.sasserver.controller;


import com.panic.sasserver.enums.UserRole;
import com.panic.sasserver.model.AppUser;
import com.panic.sasserver.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testing")
public class TestController {


    private final UserRepository userDB;

    public TestController(UserRepository userDB) {
        this.userDB = userDB;
    }

    @GetMapping("/")
    public List<AppUser> showAll(){

        return userDB.findAll();
    }
    @GetMapping("/{test}")
    public AppUser showOne(@PathVariable Long test){
        return userDB.findById(test).orElseThrow(() -> new EntityNotFoundException("User Not Found!"));
    }


    @PostConstruct
    public void test(){
        userDB.save(new AppUser("Pasdasdv","sdafasdfasd", UserRole.ADMINISTRATOR,"safsadf@gmail.com", 9912313123L,false));
    }
}
