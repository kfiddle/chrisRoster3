package com.example.demo.models.player;


import com.example.demo.enums.Part;
import com.example.demo.enums.Type;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player implements Comparable<Player> {

    @Id
    @GeneratedValue
    private Long id;

    private Type type;
    private int rank;

    @ElementCollection
    private List<Part> parts;

    private String firstNameArea;
    private String lastName;
    private String email;
    private String homePhone;
    private String cellPhone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    private Part primaryPart;

    public Player() {
        parts = new ArrayList<>();
    }

    public Player(String firstNameArea, String lastName) {
        this.firstNameArea = firstNameArea;
        this.lastName = lastName;
        parts = new ArrayList<>();
    }

    public Player(PlayerBuilder playerBuilder) {
        firstNameArea = playerBuilder.firstNameArea;
        lastName = playerBuilder.lastName;
        type = playerBuilder.type;
        rank = playerBuilder.rank;
        email = playerBuilder.email;
        homePhone = playerBuilder.homePhone;
        cellPhone = playerBuilder.cellPhone;
        addressLine1 = playerBuilder.addressLine1;
        addressLine2 = playerBuilder.addressLine2;
        city = playerBuilder.city;
        state = playerBuilder.state;
        zip = playerBuilder.zip;
        parts = playerBuilder.parts;
        if (playerBuilder.parts.size() > 0) {
            primaryPart = playerBuilder.parts.get(0);
        }
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
        this.primaryPart = parts.get(0);
    }

    public void addPart(Part part) {
        parts.add(part);
        if (parts.size() == 1) {
            primaryPart = parts.get(0);
        }
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    public int getRank() {
        return rank;
    }

    public List<Part> getParts() {
        return parts;
    }

    public String getFirstNameArea() {
        return firstNameArea;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public int compareTo(Player otherPlayer) {

        if (primaryPart.compare(otherPlayer.getPrimaryPart()) != 0) {
            return primaryPart.compare(otherPlayer.getPrimaryPart());
        } else if (rank > otherPlayer.getRank()) {
            return 1;
        } else {
            return -1;
        }

    }
}
