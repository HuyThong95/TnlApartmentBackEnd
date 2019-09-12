package com.codegym.tnlapartmentbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String apartmentName;
    @Column
    private String apartmentKind;
    @Column
    private String roomKind;
    @Column
    private String address;
    @Column
    private String numberOfRooms;
    @Column
    private String numberOfBathRooms;
    @Column
    private String description;
    @Column
    private String prize;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment() {
    }

    public Apartment(String apartmentName, String apartmentKind, String roomKind, String address, String numberOfRooms, String numberOfBathRooms, String description, String prize) {
        this.apartmentName = apartmentName;
        this.apartmentKind = apartmentKind;
        this.roomKind = roomKind;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.description = description;
        this.prize = prize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentKind() {
        return apartmentKind;
    }

    public void setApartmentKind(String apartmentKind) {
        this.apartmentKind = apartmentKind;
    }

    public String getRoomKind() {
        return roomKind;
    }

    public void setRoomKind(String roomKind) {
        this.roomKind = roomKind;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public void setNumberOfBathRooms(String numberOfBathRooms) {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
