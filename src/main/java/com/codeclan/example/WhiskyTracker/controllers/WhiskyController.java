package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


//    @GetMapping
//    public ResponseEntity<List<Whisky>> getAllWhiskies(){
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }


    @GetMapping
    public ResponseEntity findWhiskyByDistilleryNameAndWhiskyAge(
            @RequestParam(name = "distillery", required = false) String distilleryName,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "region", required = false) String region){
        if (age != null && distilleryName !=null){
            //http://localhost:8080/whiskies?distillery=Glendronach&age=15
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
        } else if (region != null){
            //http://localhost:8080/whiskies?region=Highland
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


}
