package com.example.demo.controller;

import com.example.demo.model.Acounting;
import com.example.demo.repository.AcountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class Controller {
    @Autowired
    AcountingRepository acountingRepository;


    @RequestMapping(value="/all", method=RequestMethod.GET, headers="Accept=application/json")
   public List findAll(){
       List listOfAcountings = (List) acountingRepository.findAll();
       System.out.println(listOfAcountings);
       return listOfAcountings;

   }

   @RequestMapping(value="/findById/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    public Optional<Acounting> findById(@PathVariable (value="id") int id){

         return acountingRepository.findById(id);

   }

   @RequestMapping(value="/add", method=RequestMethod.POST, headers="Accept=application/json")
    public void addAcounting(@RequestBody Acounting acounting){
       acountingRepository.save(acounting);
   }

   @RequestMapping(value="/update", method=RequestMethod.PUT, headers="Accept=application/json")
    public void updateacounting(@RequestBody Acounting acounting){
       Acounting db = acountingRepository.findById(acounting.getId()).get();
       db.setDescription("test");
       db.setTelnum(acounting.getTelnum());
       acountingRepository.save(db);
   }

   @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, headers="Accept=application/json")
    public void deleteAcounting(@PathVariable int id){
       acountingRepository.deleteById(id);
   }


}
