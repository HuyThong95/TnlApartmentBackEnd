package com.codegym.tnlapartmentbe.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String fullName;
    @NaturalId
    @NotBlank
    @Size(min = 3, max = 50)
    private String userName;
    @NaturalId
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    @NotBlank
    @Size(min = 6, max = 100)
    private String passWord;
    @NaturalId
    @NotBlank
    private String phoneNumber;

    @OneToMany(targetEntity = Apartment.class)
    private List<Apartment> apartments;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @ManyToMany
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {

    }

    public User(@NotBlank @Size(min = 3, max = 50) String fullName, @NotBlank @Size(min = 3, max = 50) String userName,
                @NotBlank @Email @Size(max = 50) String email, @NotBlank @Size(min = 6, max = 100) @NotBlank String phoneNumber, String passWord
                ) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
