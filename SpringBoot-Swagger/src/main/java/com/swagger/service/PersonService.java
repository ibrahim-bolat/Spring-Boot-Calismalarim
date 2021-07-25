package com.swagger.service;




import com.swagger.model.Person;
import com.swagger.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (this.personRepository.count() == 0) {
            IntStream.range(0, 100)
                    .mapToObj(this::create)
                    .map(this.personRepository::save)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }
    }

    private Person create(int i) {
        return Person.builder()
                .name(i+".Person")
                .surname("person"+i)
                .salary(2780)
                .birthDate(LocalDate.of(1987,05,15))
                .credit(new BigDecimal("300.000"))
                .build();
    }
    public Person savePerson(Person kisi) {

        return this.personRepository.save(kisi);
    }

    public Person updatePerson(String id, Person kisi){
        return this.personRepository.save(kisi);
    }

    public Person getPerson(String id){
        return this.personRepository.findById(id).get();
    }

    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    public void deletePerson(String id) {
       this.personRepository.deleteById(id);
    }
}
