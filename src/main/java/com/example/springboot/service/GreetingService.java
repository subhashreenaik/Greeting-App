package com.example.springboot.service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.controller.Greeting;
import com.example.springboot.entity.Greetingmessage;
import com.example.springboot.entity.User;
import com.example.springboot.repository.GreetingRepository;
import com.example.springboot.repository.UserRepository;

@Service
public class GreetingService {
	private AtomicInteger atomicint = new AtomicInteger();
	    
    @Autowired
	GreetingRepository greetingRepository;
    UserRepository userRepo;
	    
	    public String sayHelloByName(String firstName, String lastName) {
	    	return "Hello " + firstName + " " + lastName + "!!!";
		}

	    
		public User sayHello(User user) {
			User newuser = new User(user);
			userRepo.save(newuser);
	        return newuser;
		}

		public Optional<User> sayHelloById(int id) {
			 return userRepo.findById(id);
		}

		public List<User> sayHelloAll() {
			return userRepo.findAll();
		}

		public String deleteId(int id) {
			userRepo.deleteById(id);
	        return "User by id "+id+" is Deleted";
		}
		
		
		
		
		public Greetingmessage addGreeting(User user) {
	        String greetingWish = String.format("Happy birthday", (user.toString().isEmpty()) ? "Hello World!!" : user.getFirstName() + " " + user.getLastName());
	        return new Greetingmessage(atomicint.incrementAndGet(), greetingWish);
	    }


		public String deleteGreetingById(int id) {
			{ 
				
				greetingRepository.deleteById(id);
				return "Greeting data is delete -> " + id; }
			
			}


		public Greetingmessage editGreeting(int id, String firstName, String lastName) {
			Greetingmessage existingGreeting = greetingRepository.findById(id).orElse(null);
		        if (existingGreeting != null) {
		            User user = new User();
		            user.setFirstName(firstName);
		            user.setLastName(lastName);
		            String greetingWish = String.format("happy birthday", (user.toString().isEmpty()) ? "Hello World!!" : user.getFirstName() + " " + user.getLastName());
		            return greetingRepository.save(new Greetingmessage(id, greetingWish));
		        }
		        return null;
		    }


		public Greetingmessage getGreetingById(int id) {
			 return greetingRepository.findById(id).get();
	    }

        
		

	   
		
	}
