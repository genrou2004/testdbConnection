package com.raya.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ATMController {

//@Autowired
//private ThingRespository thingRespository;

    @RequestMapping  ("/")
    public String home(){

        return "login";
    }

    @GetMapping  ("/val")
    public String login(Model model){

        model.addAttribute(new Account());
        return "login";
    }

    @PostMapping ("/val")
    public @ResponseBody String processLogin(@ModelAttribute Account account){

        //ThingRespository.save(thing);
        return account.toString();

    }

   /* @RequestMapping("/")
    public @ResponseBody String getTodos(){
        return thingsRepository.findAll().toString();
    }*/
}
