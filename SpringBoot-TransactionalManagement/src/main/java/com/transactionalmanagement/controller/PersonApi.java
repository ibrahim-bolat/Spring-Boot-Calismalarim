package com.transactionalmanagement.controller;






import com.transactionalmanagement.model.Person;
import com.transactionalmanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonApi {

    private final PersonService personService;

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person) {
        return this.personService.savePerson(person);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person){
        return this.personService.updatePerson(id, person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return this.personService.getAllPerson();
    }


    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable int id){
        return this.personService.getPerson(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable int id) {
        this.personService.deletePerson(id);
    }

    @GetMapping("/getrollbackfor/{id}")
    public ResponseEntity<Person> getRollbackFor(@PathVariable int id){
        return ResponseEntity.ok(this.personService.getRollbackFor(id));
    }

    @GetMapping("/getnorollbackfor/{id}")
    public ResponseEntity<Person>  getNoRollbackFor(@PathVariable int id){
        return ResponseEntity.ok(this.personService.getNoRollbackFor(id));
    }

}
