package com.codegym.tnlapartmentbe.service.Impl;

import com.codegym.tnlapartmentbe.entity.Apartment;
import com.codegym.tnlapartmentbe.entity.User;
import com.codegym.tnlapartmentbe.repository.ApartmentRepository;
import com.codegym.tnlapartmentbe.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    ApartmentRepository apartmentRepository;

    @Override
    public List<Apartment> findAllApartment() {
        return (List<Apartment>) apartmentRepository.findAll();
    }

    @Override
    public void saveApartment(Long id, Apartment apartment) {
        apartmentRepository.save(apartment);

    }

    @Override
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);

    }

    @Override
    public Optional<Apartment> findApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public List<Apartment> findAllByUser(User user) {
        return apartmentRepository.findAllByUser(user);
    }
}
