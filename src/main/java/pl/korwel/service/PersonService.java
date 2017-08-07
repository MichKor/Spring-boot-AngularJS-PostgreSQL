package pl.korwel.service;

import pl.korwel.model.Person;
import pl.korwel.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, Long> {

    @Autowired
    private PersonRepo personRepository;

    public PersonService(PersonRepo personRepository) {
        super(personRepository);
    }
}
