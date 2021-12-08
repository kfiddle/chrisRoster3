package com.example.demo.models;




public class PlayerMaker {

    public static Player makeFrom(Player otherPlayer) {

        Player playerToMake = new Player();

        if (otherPlayer.getFirstNameArea() != null) {
            playerToMake.setFirstNameArea(otherPlayer.getLastName());
        }
        if (otherPlayer.getLastName() != null) {
            playerToMake.setLastName(otherPlayer.getLastName());
        }
        if (otherPlayer.getType() != null) {
            playerToMake.setType(otherPlayer.getType());
        }
        if (otherPlayer.getRank() > 0) {
            playerToMake.setRank(otherPlayer.getRank());
        }

        return playerToMake;
    }

}
