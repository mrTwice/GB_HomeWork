package ru.homework.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework.task.domain.User;
import ru.homework.task.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getAll(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().create(user);
        return "User added from body!";
    }
    @RequestMapping(method=RequestMethod.GET, value="/add/{name}/{age}/{email}")
    public String userAddFromParam(@PathVariable String name, @PathVariable int age, @PathVariable String email){
        service.processRegistration(name,age,email);
        return  "User added from address bar";
    }
}
