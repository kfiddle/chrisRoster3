package com.example.demo.models.player;


import com.example.demo.models.player.Player;
import com.example.demo.models.player.PlayerBuilder;

public class PlayerMaker {

    public static Player makeFrom(Player otherPlayer) {

        return new Player(new PlayerBuilder()
                .firstNameArea(otherPlayer.getFirstNameArea())
                .lastName(otherPlayer.getLastName())
                .type(otherPlayer.getType())
                .rank(otherPlayer.getRank())
                .email(otherPlayer.getEmail())
                .homePhone(otherPlayer.getHomePhone())
                .cellPhone(otherPlayer.getCellPhone())
                .addressLine1(otherPlayer.getAddressLine1())
                .addressLine2(otherPlayer.getAddressLine2())
                .city(otherPlayer.getCity())
                .state(otherPlayer.getState())
                .zip(otherPlayer.getZip())
        );
    }

}

