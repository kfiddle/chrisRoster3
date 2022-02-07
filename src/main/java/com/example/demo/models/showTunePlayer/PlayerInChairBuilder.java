package com.example.demo.models.showTunePlayer;

import com.example.demo.enums.Part;
import com.example.demo.junctions.ShowTune;
import com.example.demo.models.player.Player;

import javax.persistence.ManyToOne;
import java.util.Optional;

public class PlayerInChairBuilder {


    public Part primaryPart;
    public int rank;

    public Part secondaryPart;
    public Part thirdPart;

    public ShowTune showTune;


    public PlayerInChairBuilder() {
    }

    public PlayerInChairBuilder primaryPart(Part primaryPart) {
        Optional<Part> primaryPartOpt = Optional.ofNullable(primaryPart);
        primaryPartOpt.ifPresent(gotten -> this.primaryPart = gotten);
        return this;
    }
    public PlayerInChairBuilder rank(int rank) {
       if (rank > 0) {
           this.rank = rank;
       }
        return this;
    }
    public PlayerInChairBuilder secondaryPart(Part secondaryPart) {
        Optional<Part> secondaryPartOpt = Optional.ofNullable(secondaryPart);
        secondaryPartOpt.ifPresent(gotten -> this.secondaryPart = gotten);
        return this;
    }
    public PlayerInChairBuilder thirdPart(Part thirdPart) {
        Optional<Part> thirdPartOpt = Optional.ofNullable(thirdPart);
        thirdPartOpt.ifPresent(gotten -> this.thirdPart = gotten);
        return this;
    }

    public PlayerInChair build() {
        return new PlayerInChair(this);
    }


}
