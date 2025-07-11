package com.epicor.platform.u202111952.movilesback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class UniversityStudentWithoutCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String university;
    private String image;
    private int numberPeople;
    private String destination;
    private String pickup;
    private int price;
    private double latitude;
    private double longitude;

    // Getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getNumberPeople() { return numberPeople; }
    public void setNumberPeople(int numberPeople) { this.numberPeople = numberPeople; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getPickup() { return pickup; }
    public void setPickup(String pickup) { this.pickup = pickup; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}
