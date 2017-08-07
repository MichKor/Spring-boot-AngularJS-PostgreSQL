package pl.korwel.controller;

import pl.korwel.model.Person;
import pl.korwel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<Person> getAllPersons() {
        return personService.getAll();
    }

    @GetMapping("/persons/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Person getPerson(@PathVariable Long id) {
        return  personService.getOne(id);
    }

    @PostMapping("/persons")
    @Secured("ROLE_ADMIN")
    public void addPerson(@RequestBody Person person) {
        personService.addNew(person);
    }

    @PutMapping("/persons/{id}")
    @Secured("ROLE_ADMIN")
    public void updatePerson(@RequestBody Person person, @PathVariable Long id) {
        personService.update(id, person);
    }

    @DeleteMapping("/persons/{id}")
    @Secured("ROLE_ADMIN")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }
}
