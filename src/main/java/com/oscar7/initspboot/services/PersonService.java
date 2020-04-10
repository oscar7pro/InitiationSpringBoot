package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    public Page<Person> findPersonsPaginated(Pageable pageable);

    public Person createPerson();
}
