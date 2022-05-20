package com.example.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Greetingmessage;
import com.example.springboot.entity.User;



/**
 * @purpose -> UC4: Ability for the Greeting App to save the Greeting Message in the Repository
 */
@Repository
public interface GreetingRepository extends JpaRepository<Greetingmessage, Integer>{

}
