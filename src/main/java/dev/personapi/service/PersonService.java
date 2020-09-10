package dev.personapi.service;

import dev.personapi.dto.PersonDTO;
import dev.personapi.entity.Person;
import dev.personapi.exception.PersonNotFoundException;
import dev.personapi.mapper.PersonMapper;
import dev.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;

    public PersonDTO create(PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

        person = personRepository.save(person);

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> getAll() {
        List<Person> persons = personRepository.findAll();

        return personMapper.toDTOs(persons);
    }

    public PersonDTO getById(Long id) {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        Person person = verifyIfExists(id);

        personMapper.updatePerson(personDTO, person);
        person = personRepository.save(person);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

}
