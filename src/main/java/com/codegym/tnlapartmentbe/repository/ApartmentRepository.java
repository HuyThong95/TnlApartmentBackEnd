package com.codegym.tnlapartmentbe.repository;

import com.codegym.tnlapartmentbe.entity.Apartment;
import com.codegym.tnlapartmentbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAllByUser(User user);

}
