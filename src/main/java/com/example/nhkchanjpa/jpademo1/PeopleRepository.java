package com.example.nhkchanjpa.jpademo1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PeopleRepository extends CrudRepository<People, Long> {

    List<People> findByLname(String lname);
    
    @Query("SELECT p FROM People p WHERE LOWER(p.lname) = LOWER(:lastName)")
    public List<People> find(@Param("lastName") String lname);
    
}