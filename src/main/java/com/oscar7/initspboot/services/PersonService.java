package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonService extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findAllById(int id, Pageable pageable);
}
