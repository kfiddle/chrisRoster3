package com.example.demo.models;


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

    public Player() {
        parts = new ArrayList<>();
    }

    public Player(String firstNameArea, String lastName) {
        this.firstNameArea = firstNameArea;
        this.lastName = lastName;
        parts = new ArrayList<>();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public void setFirstNameArea(String firstNameArea) {
        this.firstNameArea = firstNameArea;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Part getPrimary() {
        return parts.get(0);
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

    @Override
    public int compareTo(Player o) {
        return 0;
    }
}
