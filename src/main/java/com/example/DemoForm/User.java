package com.example.DemoForm;

import com.example.DemoForm.validation.Age;
import com.example.DemoForm.validation.Username;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public class User {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "First name is too short")
    private String firstName;

    @NotBlank(message = "lastname cannot be blank")
    private String lastName;
    @Username(message = "Cannot contain special characters or uppercase characters ")
    @NotBlank(message = "username cannot be blank")
    @Size(min = 7, message = "First name is too short")
    private String userName;

    @Email(message = "Invalid email")
    private String email;
@Age
  @Past(message ="date of birth invalid")
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {this.id = UUID.randomUUID().toString();
    }
}
