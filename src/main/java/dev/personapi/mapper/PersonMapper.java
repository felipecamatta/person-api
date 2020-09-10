package dev.personapi.mapper;

import dev.personapi.dto.PersonDTO;
import dev.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(dateFormat = "dd-MM-yyyy", source = "birthDate", target = "birthDate")
    Person toPerson(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

    List<PersonDTO> toDTOs(List<Person> person);

    @Mapping(target = "id", ignore = true)
    void updatePerson(PersonDTO personDTO, @MappingTarget Person person);

}
