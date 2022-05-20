package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "greetingwishmessage")
public class Greetingmessage {
	
	    @Id
	    @GeneratedValue
	    private int id;

	    private  String message;

	    public Greetingmessage(int id, String message) {
	        this.id = id;
	        this.message = message;
	    }

	    public Greetingmessage() {
	        id = 0;
	        message = "";
	    }
	    
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    @Override
	    public String toString() {
	    	return message;
	    }

	}