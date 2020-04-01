package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {


    @Autowired
    DistilleryRepository distilleryRepository;


    @GetMapping
    public ResponseEntity findDistilleriesByRegion(
            @RequestParam(name = "region", required = false) String region) {
        if (region != null){
            //http://localhost:8080/distilleries?region=Highland
            return new ResponseEntity(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        //http://localhost:8080/distilleries
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/age12")
    public ResponseEntity findWhiskiesThatAre12 (@RequestParam(name = "age12", required = false) Integer age12){
        return new ResponseEntity(distilleryRepository.findDistilleryByWhiskiesAgeIs(12), HttpStatus.OK);
    }

}


