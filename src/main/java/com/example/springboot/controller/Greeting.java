package com.example.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Greetingmessage;
import com.example.springboot.entity.User;
import com.example.springboot.service.GreetingService;

@RestController
@RequestMapping("/user")
public class Greeting {
	 
    @Autowired
    GreetingService greetingService;
    
    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (lastName == null) lastName = "";
        else if (firstName == null) firstName = "";
        
        return greetingService.sayHelloByName(firstName, lastName);
    }
    
    
    @PostMapping("/post")
    public User sayHello (@RequestBody User user){
    User newuser = greetingService.sayHello(user);
    return newuser;
    }
    
    @GetMapping("/user/{id}")
    public Optional<User> sayHelloById (@PathVariable int id){
        Optional<User> response = greetingService.sayHelloById(id);
        return response;
    }
    @GetMapping("/users")
    public List<User> sayHelloToAll (){
        List<User> response = greetingService.sayHelloAll();
        return response;
    }
    @DeleteMapping ("/user/{id}")
    public String  deleteUser (@PathVariable int id){
        String response = greetingService.deleteId(id);
        return response;
    }
    
    /**
     * @purpose -> UC1 : Using GreetingController return JSON for different HTTP Methods.
     *          -> UC2 : GreetingController to use Services Layer to get Simple Greeting message ” Hello World ”
     * @param fistName
     * @param lastName
     * @return -> It returns the JSON format greeting Message
     */
    
    @GetMapping(value = {"","/","/greeting"})
    public Greetingmessage greeting(@RequestParam(value = "fistName",defaultValue = "Hello") String fistName, @RequestParam(value = "lastName",defaultValue = "World") String lastName){
        User user = new User();
        user.setFirstName(fistName);
        user.setLastName(lastName);
        Greetingmessage greetingForm = greetingService.addGreeting(user);
        System.out.println(greetingForm);
        return greetingForm;
    }
    /**
     * @purpose -> UC5 : Ability for the Greeting App to find a Greeting Message by Id in the Repository
     * @param id
     * @return -> It returns the Greeting Message form the H2 DataBase
     */
    @GetMapping("/GreetingById/{id}")
    public Greetingmessage findGreetingById(@PathVariable int id) { return greetingService.getGreetingById(id);
    }
    
    @PutMapping("/editGreeting/{id}/{firstName}/{lastName}")
    public Greetingmessage editGreetingName(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName){ return greetingService.editGreeting(id,firstName,lastName); }

    @DeleteMapping("/deleteGreetingById/{id}")
    public String deleteGreetingById(@PathVariable int id) {return greetingService.deleteGreetingById(id);}
}
