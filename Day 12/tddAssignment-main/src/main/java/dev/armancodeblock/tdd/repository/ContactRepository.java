package dev.armancodeblock.tdd.repository;


import dev.armancodeblock.tdd.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Person, Integer> {
}
