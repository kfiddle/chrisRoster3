package com.example.demo.models.piece;


import com.example.demo.enums.Part;

import javax.persistence.Embeddable;

@Embeddable
public class ScoreLine {

    private Part primaryPart;
    private int number;

    private Part secondaryPart;
    private Part thirdPart;

    public ScoreLine() {
    }

    public ScoreLine(Part primaryPart, int number) {
        this.primaryPart = primaryPart;
        this.number = number;
    }

    public ScoreLine(Part primaryPart, int number, Part secondaryPart) {
        this.primaryPart = primaryPart;
        this.number = number;
        this.secondaryPart = secondaryPart;
    }

    public ScoreLine(Part primaryPart, int number, Part secondaryPart, Part thirdPart) {
        this.primaryPart = primaryPart;
        this.number = number;
        this.secondaryPart = secondaryPart;
        this.thirdPart = thirdPart;
    }

    public void setPrimaryPart(Part primaryPart) {
        this.primaryPart = primaryPart;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSecondaryPart(Part secondaryPart) {
        this.secondaryPart = secondaryPart;
    }

    public void setThirdPart(Part thirdPart) {
        this.thirdPart = thirdPart;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    public int getNumber() {
        return number;
    }

    public Part getSecondaryPart() {
        return secondaryPart;
    }

    public Part getThirdPart() {
        return thirdPart;
    }
}
