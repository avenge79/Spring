package com.rado.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("user")
@RestController
public class HomeController{

private final UsersService usersService;

    @Autowired
    private UserRepository userRepository;

    public HomeController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/find-all")
    public List<Users> findAll() {
        return userRepository.findAll();
    }
/*
    @GetMapping("/new")
    public Users addNew() {
        Users user = new Users();
        user.setEmail("rm@m.com");
        user.setName("RMM");
        return userRepository.save(user);
    }*/

    @PostMapping
    public void addUser(@Valid @NotNull @RequestBody Users user) {
        usersService.addUser(user);
    }
}
