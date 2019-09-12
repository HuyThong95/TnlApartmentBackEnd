package com.codegym.tnlapartmentbe.controller;

import com.codegym.tnlapartmentbe.entity.Role;
import com.codegym.tnlapartmentbe.entity.RoleName;
import com.codegym.tnlapartmentbe.entity.User;
import com.codegym.tnlapartmentbe.form.SignUpForm;
import com.codegym.tnlapartmentbe.repository.RoleRepository;
import com.codegym.tnlapartmentbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class SignUpController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest ){
        if (userRepository.existsByUserName(signUpRequest.getUserName())){
            return new ResponseEntity<>("Name taken", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())){
            return new ResponseEntity<>("Email used", HttpStatus.BAD_REQUEST);
        }
        User user = new User(
                signUpRequest.getFullName(),
                signUpRequest.getUserName(),
                signUpRequest.getEmail(),
                signUpRequest.getPhoneNumber(),
                passwordEncoder.encode(signUpRequest.getPassWord()) );
        Set<String> strRoles = signUpRequest.getRole();

        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role){
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
                    roles.add(adminRole);
                    break;
                case "user":
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
                    roles.add(userRole);
                    break;

                default:
                    Role guestRole = roleRepository.findByName(RoleName.ROLE_GUEST);
                    roles.add(guestRole);

            }
        });
        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>("registered successfully", HttpStatus.OK);
    }
}
