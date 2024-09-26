package ru.lysenko.restapijpa.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {
    @NotEmpty(message = "Name should not be empty!") //имя не должно быть пустым
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    public @NotEmpty(message = "Name should not be empty!") @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name should not be empty!") @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!") String name) {
        this.name = name;
    }

    @Min(value = 0, message = "Age should be greater than 0")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "Age should be greater than 0") int age) {
        this.age = age;
    }

    public @Email @NotEmpty(message = "Email should not be empty") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotEmpty(message = "Email should not be empty") String email) {
        this.email = email;
    }

    public PersonDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
