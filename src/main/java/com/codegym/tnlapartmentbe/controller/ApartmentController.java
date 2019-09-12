package com.codegym.tnlapartmentbe.controller;

import com.codegym.tnlapartmentbe.entity.Apartment;
import com.codegym.tnlapartmentbe.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping(value = "/apartments", method = RequestMethod.GET)
    public ResponseEntity<List<Apartment>> showAllApartment(){
        return new ResponseEntity<>(apartmentService.findAllApartment(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create-apartment", method = RequestMethod.POST)
    public ResponseEntity<String> createApartment(@RequestBody Apartment apartment){
        apartmentService.saveApartment(apartment.getId(), apartment);
        return new ResponseEntity<>("Apartment created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete-apartment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteApartment(@PathVariable("id") Long id){
        apartmentService.deleteApartment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/edit-apartment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editApartment(@PathVariable("id") Long id, @RequestBody Apartment apartment){
        apartmentService.deleteApartment(id);
        apartment.setId(id);
        apartmentService.saveApartment(id, apartment);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/apartment/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> detailsApartment(@PathVariable("id") Long id){
        return new ResponseEntity<>(apartmentService.findApartmentById(id), HttpStatus.OK);
    }


}
