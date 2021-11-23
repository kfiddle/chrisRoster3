package com.example.demo;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.models.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }


    public static void main(String[] args) {

        Player maureen = new Player("Maureen", "Conlon");
        Player will = new Player("Will", "TeeGarden");

        Piece russlan = new Piece();
        russlan.setTitle("Ruslan and Lud");

        Piece beeth4 = new Piece();
        beeth4.setTitle("Symphony 4");

        List<PieceOnProgram> firstProgram = new ArrayList<>();
        firstProgram.add(new PieceOnProgram(russlan));
        firstProgram.add(new PieceOnProgram(beeth4));

        Performance show1 = new Performance();
        show1.setProgram(firstProgram);

       for (PieceOnProgram pp : show1.getProgram()) {
           System.out.println(pp.getPiece().getTitle());
       }

    }


}
