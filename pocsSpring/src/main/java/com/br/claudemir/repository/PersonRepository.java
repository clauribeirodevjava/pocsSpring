package com.br.claudemir.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.claudemir.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
