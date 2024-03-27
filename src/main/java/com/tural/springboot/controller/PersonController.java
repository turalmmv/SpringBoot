package com.tural.springboot.controller;

import com.tural.springboot.dto.PersonDto;
import com.tural.springboot.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/getAll")
    public LinkedList<PersonDto> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/getById")
    public List<PersonDto> getPersonById(@RequestHeader("id") Long id) {
        return personService.getPersonById(id);
    }


    @PostMapping("/create")
    public String create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PutMapping("/update")
    public String update(@RequestHeader("id") Long id, @RequestBody PersonDto personDto) {
        return personService.update(id, personDto);
    }

    @PatchMapping("/updateAge")
    public String updatePatch(@RequestHeader("id") Long id, @RequestHeader("newAge") Integer age) {
        return personService.updatePatch(id, age);
    }


    @DeleteMapping("/delete")
    public String delete(@RequestHeader("id") Long id) {
        return personService.delete(id);
    }



}
