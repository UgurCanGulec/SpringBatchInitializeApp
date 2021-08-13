package com.j4v4developers.reader;

import com.j4v4developers.model.Person;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.List;


public class InMemoryReader extends AbstractItemStreamItemReader<Person> {

    Person ugur = Person.builder().id(1L).name("Uğur Can").surname("Güleç").job("Java Developer").salary(4000).workYear(1).build();
    Person ali = Person.builder().id(2L).name("Ali").surname("Canlısoy").job("Software Architect").salary(8000).workYear(5).build();
    Person veli = Person.builder().id(3L).name("Veli").surname("Cansızsoy").job("Scrum Master").salary(10000).workYear(7).build();
    Person can = Person.builder().id(4L).name("Can").surname("Burdur").job("Agile Master").salary(11000).workYear(10).build();
    Person selim = Person.builder().id(5L).name("Selim").surname("Arabacı").job("Test Engineer").salary(7500).workYear(2).build();
    Person mehmet = Person.builder().id(6L).name("Mehmet").surname("Hanlı").job("Java Developer").salary(4000).workYear(1).build();
    Person tarik = Person.builder().id(7L).name("Tarık").surname("Ünlü").job("Scrum Master").salary(10000).workYear(7).build();
    Person hamza = Person.builder().id(8L).name("Hamza").surname("Metinci").job("Software Architect").salary(15000).workYear(15).build();
    Person hamdi = Person.builder().id(9L).name("Hamdi").surname("Laleci").job("Product Owner").salary(20000).workYear(20).build();
    Person atakan = Person.builder().id(10L).name("Atakan").surname("Kahveci").job("Java Developer").salary(10000).workYear(10).build();
    Person salim = Person.builder().id(11L).name("Salim").surname("Merkezefendi").job("Business Analysis").salary(6000).workYear(4).build();
    Person sami = Person.builder().id(12L).name("Sami").surname("Ekolcü").job("Test Engineer").salary(6000).workYear(3).build();
    Person murat = Person.builder().id(13L).name("Murat").surname("Hunlu").job("Java Developer").salary(4000).workYear(2).build();

    List<Person> persons = List.of(ugur, ali, veli, can, selim, mehmet, tarik, hamza, hamdi, atakan, salim, sami, murat);
    int index = 0;

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Person nextItem = null;
        if (index < persons.size()) {
            nextItem = persons.get(index);
            index++;
        }else {
            index = 0;
        }
        return nextItem;
    }
}
