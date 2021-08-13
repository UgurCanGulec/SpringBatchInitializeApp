package com.j4v4developers.writer;

import com.j4v4developers.model.Person;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

public class ConsoleItemWriter extends AbstractItemStreamItemWriter<Person> {

    @Override
    public void write(List<? extends Person> items) throws Exception {
        items.forEach(System.out::println);
        System.out.println("Writing each chunk");
    }
}
