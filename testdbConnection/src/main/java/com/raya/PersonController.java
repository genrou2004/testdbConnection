package com.raya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
@RestController
@RequestMapping("/person")
public class PersonController {
@Autowired
 PersonRepository personRepository;

    /**
     * GET /create  --> Create a new person and save it in the database.
     */
    @RequestMapping("/create")
    public Person create(Person person) {
        person.setFirstName(person.getFirstName());
        person.setLastName(person.getLastName());
        person = personRepository.save(person);
        return person;
    }


    /**
     * GET /read  --> Read a person by booking id from the database.
     */
    @RequestMapping("/read")
    public Person read(@RequestParam int id) {
        Person person = personRepository.findById(id);
        return person;
    }

    /**
     * GET /update  --> Update a person record and save it in the database.
     */
    @RequestMapping("/update")
    public Person update(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Person person = personRepository.findById(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person = personRepository.save(person);
        return person;
    }

    /**
     * GET /delete  --> Delete a person from the database.
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam int id) {
        personRepository.delete(id);
        return "person #"+id+" deleted successfully";
    }

    /*@GetMapping   ("/val")
    public String login(Model model){

        model.addAttribute(new Person());
        return "index";
    }

    @PostMapping  ("/val")
    public @ResponseBody  String processLogin(@ModelAttribute  Person person){

        //ThingRespository.save(thing);
        return person.toString();

    }

   @RequestMapping ("/val")
    public @ResponseBody String getPerson(){
        return personRepository.findAll().toString();
    }*/

}
