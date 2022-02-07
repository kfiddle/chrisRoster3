package com.example.demo.models.piece;


import com.example.demo.enums.Part;

import javax.persistence.Embeddable;

@Embeddable
public class EmptyChair {

    private Part primaryPart;
    private int rank;

    private Part secondaryPart;
    private Part thirdPart;

    public EmptyChair() {
    }

    public EmptyChair(Part primaryPart, int rank) {
        this.primaryPart = primaryPart;
        this.rank = rank;
    }

    public EmptyChair(Part primaryPart, int rank, Part secondaryPart) {
        this.primaryPart = primaryPart;
        this.rank = rank;
        this.secondaryPart = secondaryPart;
    }

    public EmptyChair(Part primaryPart, int rank, Part secondaryPart, Part thirdPart) {
        this.primaryPart = primaryPart;
        this.rank = rank;
        this.secondaryPart = secondaryPart;
        this.thirdPart = thirdPart;
    }

    public void setPrimaryPart(Part primaryPart) {
        this.primaryPart = primaryPart;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public int getRank() {
        return rank;
    }

    public Part getSecondaryPart() {
        return secondaryPart;
    }

    public Part getThirdPart() {
        return thirdPart;
    }
}
