package pk.sample.WebFluxApp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.sample.WebFluxApp.model.Person;
import pk.sample.WebFluxApp.service.UserService;
import reactor.core.publisher.Flux;


import java.time.Duration;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Person>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Person> getUser(@PathVariable("id") int id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private void deleteStudent(@PathVariable("id") int id)
    {
        userService.delete(id);
    }
    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Integer> saveUser(@RequestBody Person user)
    {
        userService.saveOrUpdate(user);
        return ResponseEntity.ok(Integer.valueOf(user.getId()));
    }
    @GetMapping(value = "/stream/json/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<List<Person>> streamJsonObjects() {
        return Flux.interval(Duration.ofSeconds(10)).map(i -> userService.getAllUsers());
    }
}
