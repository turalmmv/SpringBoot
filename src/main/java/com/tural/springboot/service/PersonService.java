package com.tural.springboot.service;

import com.tural.springboot.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PersonService {

    LinkedList<PersonDto> personDtos = new LinkedList<>();

    public LinkedList<PersonDto> getPersons() {
        return personDtos;
    }

    public List<PersonDto> getPersonById(Long id) {
        return personDtos.stream().filter(personDto -> Objects.equals(personDto.getId(), id)).collect(Collectors.toList());
    }


    public String create(PersonDto personDto) {
        personDtos.add(personDto);
        return "Successfully added.";
    }


    public String update(Long id, PersonDto personDto) {
        for (PersonDto personDto1 : personDtos) {
            if (Objects.equals(personDto1.getId(), id)) {
                personDto1.setId(personDto.getId());
                personDto1.setFirstName(personDto.getFirstName());
                personDto1.setLastName(personDto.getLastName());
                personDto1.setAge(personDto.getAge());
            }
        }
        return "Successfully update.";
    }

    public String updatePatch(Long id,Integer age) {
        for (PersonDto personDto1 : personDtos) {
            if (Objects.equals(personDto1.getId(), id)) {
                personDto1.setAge(age);
            }
        }
        return "Successfully update patch";
    }

    public String delete(Long id) {
        personDtos.removeIf(personDto -> Objects.equals(personDto.getId(), id));
        return "Successfully deleted.";
    }


}
