package com.j4v4developers.processor;

import com.j4v4developers.model.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class InMemoryItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        double raiseRate = person.getWorkYear() / 100d;
        person.setSalary((int) (person.getSalary() + (person.getSalary() * raiseRate)));
        return person;
    }
}
