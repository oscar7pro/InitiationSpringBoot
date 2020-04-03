package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> findAllById(int id, Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Person> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        Pageable pageWithTwoElements = PageRequest.of(0, 2);
        return null;
    }

    @Override
    public <S extends Person> S save(S s) {
        return null;
    }

    @Override
    public <S extends Person> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Person> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Person> findAll() {
        return null;
    }

    @Override
    public Iterable<Person> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void deleteAll(Iterable<? extends Person> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
