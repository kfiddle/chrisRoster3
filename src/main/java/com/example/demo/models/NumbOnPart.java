package com.example.demo.models;


import com.example.demo.enums.Part;

import javax.persistence.Embeddable;

@Embeddable
public class NumbOnPart implements Comparable<NumbOnPart> {

    private Part part;
    private int number;

    public NumbOnPart() {
    }

    public NumbOnPart(Part part, int number) {
        this.part = part;
        this.number = number;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Part getPart() {
        return part;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(NumbOnPart other) {
        return part.compare(other.getPart());
    }
}
