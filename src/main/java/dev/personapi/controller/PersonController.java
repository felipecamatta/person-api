package dev.personapi.controller;

import dev.personapi.dto.PersonDTO;
import dev.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) {
        return personService.update(id, personDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

}
