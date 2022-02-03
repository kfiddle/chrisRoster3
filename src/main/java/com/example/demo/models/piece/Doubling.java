package com.example.demo.models.piece;


import com.example.demo.enums.Part;

import javax.persistence.Embeddable;

@Embeddable
public class Doubling {

    private Part primaryPart;
    private int partRank;
    private Part secondaryPart;

    public Doubling() {
    }

    public Doubling(Part primaryPart, int partRank, Part secondaryPart) {
        this.primaryPart = primaryPart;
        this.partRank = partRank;
        this.secondaryPart = secondaryPart;
    }

    public void setPrimaryPart(Part primaryPart) {
        this.primaryPart = primaryPart;
    }

    public void setPartRank(int partRank) {
        this.partRank = partRank;
    }

    public void setSecondaryPart(Part secondaryPart) {
        this.secondaryPart = secondaryPart;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    public int getPartRank() {
        return partRank;
    }

    public Part getSecondaryPart() {
        return secondaryPart;
    }
}
