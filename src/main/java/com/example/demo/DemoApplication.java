package com.example.demo;

import com.example.demo.enums.Part;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.NumbOnPart;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.models.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    public static void main(String[] args) {
//
//        Player maureen = new Player("Maureen", "Conlon");
//        Player will = new Player("Will", "TeeGarden");
//
//        maureen.addPart(Part.Violin1);
//        maureen.addPart(Part.Viola);
//        maureen.addPart(Part.Timpani);
//
//
//        Piece russlan = new Piece();
//        russlan.setTitle("Russlan and Lud");
//
//        Piece beeth4 = new Piece();
//        beeth4.setTitle("Symphony 4");
//
//        List<PieceOnProgram> firstProgram = new ArrayList<>();
//
//        PieceOnProgram russlanOnShow1 = new PieceOnProgram(russlan);
//        PieceOnProgram beethOnShow1 = new PieceOnProgram(beeth4);
//
//        Performance show1 = new Performance();
//
//        firstProgram.add(russlanOnShow1);
//        firstProgram.add(beethOnShow1);
//
//        show1.setProgram(firstProgram);
//
//        Collection<NumbOnPart> partsForRusslan = new ArrayList<NumbOnPart>();
//        partsForRusslan.add(new NumbOnPart(Part.Violin1, 2));
//        partsForRusslan.add(new NumbOnPart(Part.Viola,2));
//
//        russlan.setOrchestration(partsForRusslan);
//        for (NumbOnPart numbOnPart : russlan.getOrchestration()) {
//            System.out.println(numbOnPart.getPart() + "  " + numbOnPart.getNumber());
//        }
//        System.out.println(maureen.getParts().get(2));
//    }




}
