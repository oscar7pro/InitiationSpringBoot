package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.utils.PersonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    final List<Person> persons = PersonUtils.buildPersons();

    public Page<Person> findPersonsPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startPersonPage = currentPage * pageSize;
        List<Person> list;
        if (persons.size() < startPersonPage) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startPersonPage + pageSize, persons.size());
            list = persons.subList(startPersonPage, toIndex);
        }
        Page<Person> personPage = new PageImpl<Person>(list, PageRequest.of(currentPage, pageSize), persons.size());
        return personPage;
    }

    @Override
    public Person createPerson() {
        Person person = new Person();
        person.setId(person.getId());
        person.setName(person.getName());
        person.setEmail(person.getEmail());
        person.setBirthDay(person.getBirthDay());
        person.setFirstName(person.getFirstName());
        return person;

    }
}
