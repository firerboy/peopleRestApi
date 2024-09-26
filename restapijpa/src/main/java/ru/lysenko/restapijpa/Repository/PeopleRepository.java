package ru.lysenko.restapijpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lysenko.restapijpa.model.Person;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
