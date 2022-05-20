package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="greeting")
public class User {
	
@Id
@GeneratedValue
private int id;

@Column(nullable = false, length = 100)
String firstName;

@Column(nullable = false, length = 100)
String lastName;

public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

public User() {
}

public User(User user) {
    this.firstName = user.firstName;
    this.lastName = user.lastName;
}


public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

@Override
public String toString() {
    return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
}

public int getId() {
    return Math.toIntExact(id);
}

public void setId(int id) {
    this.id = id;
}
}
