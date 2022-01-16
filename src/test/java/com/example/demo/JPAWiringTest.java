package com.example.demo;


import com.example.demo.enums.Part;
import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.PieceBuilder;
import com.example.demo.models.player.Player;
import com.example.demo.models.player.PlayerBuilder;
import com.example.demo.repositories.PerformanceRepo;
import com.example.demo.repositories.PieceOnProgramRepo;
import com.example.demo.repositories.PieceRepo;
import com.example.demo.repositories.PlayerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JPAWiringTest {


    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private PerformanceRepo performanceRepo;

    @Autowired
    private PieceRepo pieceRepo;

    @Autowired
    private PieceOnProgramRepo ppRepo;

    @Test
    public void shouldBeAbleToSeeIfPlayerIsOnPiece() {

        Player testPlayer = new PlayerBuilder().firstNameArea("Sam").lastName("Elliot").build();
        playerRepo.save(testPlayer);

        Performance testShow1 = new Performance();
        performanceRepo.save(testShow1);

        Piece firstPiece = new PieceBuilder().title("First Piece").build();
        pieceRepo.save(firstPiece);

        PieceOnProgram firstOnShow = new PieceOnProgram(firstPiece, testShow1);
        ppRepo.save(firstOnShow);

        Player retrievedSam = playerRepo.findByFirstNameAreaAndLastName("Sam", "Elliot");

        PInChair samsChair = new PInChair(Part.Violin1, 3);

        retrievedSam.addPart(Part.Violin1);
        retrievedSam.setRank(2);
        assertTrue(retrievedSam.canPlayerSitHere(samsChair));







    }


}
