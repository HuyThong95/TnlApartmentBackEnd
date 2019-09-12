package com.codegym.tnlapartmentbe.controller;

import com.codegym.tnlapartmentbe.entity.Apartment;
import com.codegym.tnlapartmentbe.entity.User;
import com.codegym.tnlapartmentbe.service.ApartmentService;
import com.codegym.tnlapartmentbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApartmentService apartmentService;
    @RequestMapping(value = "/view-user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Apartment>> viewUser(@PathVariable("id") Long id, User user){
        userService.findUserById(id);
        List<Apartment> apartments = apartmentService.findAllByUser(user);
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }
}
