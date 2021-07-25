package com.swagger.controller;





import com.swagger.model.Person;
import com.swagger.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
@Api(value = "Person Api documentation")
public class PersonApi {

    private final PersonService personService;

    @ApiOperation(value = "New Person adding method")
    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person) {
        return this.personService.savePerson(person);
    }

    @ApiOperation(value = "Person update method")
    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person person){
        return this.personService.updatePerson(id, person);
    }

    @ApiOperation(value = "All people list method")
    @GetMapping
    public List<Person> getAllPerson() {
        return this.personService.getAllPerson();
    }

    @ApiOperation(value = "Person get method")
    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable String id){
        return this.personService.getPerson(id);
    }


    @ApiOperation(value = "Person delete method")
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable String id) {
        this.personService.deletePerson(id);
    }

}
