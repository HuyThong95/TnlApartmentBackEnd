package com.codegym.tnlapartmentbe.service;

import com.codegym.tnlapartmentbe.entity.Apartment;
import com.codegym.tnlapartmentbe.entity.User;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
   public List<Apartment> findAllApartment();
   public void saveApartment(Long id, Apartment apartment);
   public void deleteApartment(Long id);
   public Optional<Apartment> findApartmentById(Long id);
   public List<Apartment> findAllByUser(User user);
}
