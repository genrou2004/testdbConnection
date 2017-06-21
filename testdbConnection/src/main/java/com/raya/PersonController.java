package com.raya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class PersonController {

@Autowired
 private PersonRepository personRepository;


    @RequestMapping ("/")
    public String home(Model model){
        model.addAttribute("person",new Person());
        return "create";
    }

    @GetMapping("/create")
    public String getStudent(Model model){
        model.addAttribute(new Person());
        model.addAttribute("person", personRepository.findAll());
        return "read";
    }

    @PostMapping("/create")
    public String processStudent(@Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "read";
        }
        personRepository.save(person);
        return "redirect:/create";
    }
}
