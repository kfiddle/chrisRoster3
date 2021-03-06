package com.example.demo.models.player;


import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.junctions.PInChair;

import javax.persistence.*;
import java.util.*;

@Entity
public class Player implements Comparable<Player> {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int rank;

    @ElementCollection
    private List<Part> parts = new ArrayList<>();

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

    //    @org.hibernate.annotations.Formula("select parts[0]")
    private Part primaryPart;

    public Player() {
    }

    public Player(String firstNameArea, String lastName) {
        this.firstNameArea = firstNameArea;
        this.lastName = lastName;
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

    public boolean canPlayerSitHere(PInChair pInChair) {
        boolean flag = false;
        for (Part part : parts) {
            if (part == pInChair.getPart() && rank <= pInChair.getRank()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void setAllProps(Player otherPlayer) {

        if (otherPlayer.getFirstNameArea() != null) {
            firstNameArea = otherPlayer.getFirstNameArea();
        }
        if (otherPlayer.getLastName() != null) {
            lastName = otherPlayer.getLastName();
        }
        if (otherPlayer.getType() != null) {
            type = otherPlayer.getType();
        }
        if (otherPlayer.getParts() != null) {
            parts = otherPlayer.getParts();
            primaryPart = parts.get(0);
        }
        if (otherPlayer.getRank() > 0) {
            rank = otherPlayer.getRank();
        }
        if (otherPlayer.getEmail() != null) {
            email = otherPlayer.getEmail();
        }
        if (otherPlayer.getHomePhone() != null) {
            homePhone = otherPlayer.getHomePhone();
        }
        if (otherPlayer.getCellPhone() != null) {
            cellPhone = otherPlayer.getCellPhone();
        }
        if (otherPlayer.getAddressLine1() != null) {
            addressLine1 = otherPlayer.getAddressLine1();
        }

        if (otherPlayer.getAddressLine2() != null) {
            addressLine2 = otherPlayer.getAddressLine2();
        }

        if (otherPlayer.getCity() != null) {
            city = otherPlayer.getCity();
        }

        if (otherPlayer.getState() != null) {
            state = otherPlayer.getState();
        }

        if (otherPlayer.getZip() != null) {
            zip = otherPlayer.getZip();
        }


    }

    @Override
    public int compareTo(Player otherPlayer) {

        if (primaryPart.compare(otherPlayer.getPrimaryPart()) != 0) {
            return primaryPart.compare(otherPlayer.getPrimaryPart());
        } else if (rank > otherPlayer.getRank()) {
            return 1;
        } else return type.compare(otherPlayer.getType());
    }
}
