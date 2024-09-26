package ru.lysenko.restapijpa.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lysenko.restapijpa.Repository.PeopleRepository;
import ru.lysenko.restapijpa.dto.PersonDTO;
import ru.lysenko.restapijpa.model.Person;
import ru.lysenko.restapijpa.util.PersonNotDeleteException;
import ru.lysenko.restapijpa.util.PersonNotFoundException;
import ru.lysenko.restapijpa.util.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }

    public Person updatePerson(int id, Person personDetails) {
        Person person = peopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        // Обновляем необходимые поля
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        person.setAge(personDetails.getAge());
        // добавьте другие поля по необходимости

        return peopleRepository.save(person);
    }

    public void deletePerson(int id){
        peopleRepository.deleteById(id);
    }

    @Transactional
    public void save(Person person){
        enrichPerson(person);
        peopleRepository.save(person);
    }

    private void enrichPerson(Person person) {
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }
}
