package com.oscar7.initspboot.utils;

import com.oscar7.initspboot.entities.Person;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonUtils {
    static List<Person> persons = new ArrayList<>();
    static final int COUNT_PERSONS = 75;
    static final int MIN_COUNT_PERSONS = 1000;

    public static List<Person> buildPersons() {
        if (persons.isEmpty()) {
            IntStream.range(0, COUNT_PERSONS).forEach(n -> {
                persons.add(new Person(MIN_COUNT_PERSONS + n + 1, "Dalhia", "Kimasch", "dalhia@oscar7pro.com", "21/06/1985"));
            });
        }
        return persons;
    }


}
