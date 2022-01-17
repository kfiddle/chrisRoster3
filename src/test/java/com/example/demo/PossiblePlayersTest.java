package com.example.demo;


import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PossiblePlayersTest {

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
    public void shouldReturnAllPossiblePlayers() {

        Player leAnne = new PlayerBuilder().firstNameArea("Leanne").lastName("Wistrom").type(Type.CONTRACTED).rank(1).addAPart(Part.Flute).build();
        Player seanG = new PlayerBuilder().firstNameArea("Sean").lastName("Gabriel").type(Type.CONTRACTED).rank(2).addAPart(Part.Flute).build();
        Player danna = new PlayerBuilder().firstNameArea("Danna").lastName("Sundet").type(Type.CONTRACTED).rank(1).addAPart(Part.Oboe).build();
        Player heatherS = new Player(new PlayerBuilder().firstNameArea("Heather").lastName("Story").type(Type.CONTRACTED).rank(2).addAPart(Part.Oboe));
        Player sarahH = new Player(new PlayerBuilder().firstNameArea("Sarah").lastName("Hamilton").type(Type.CONTRACTED).rank(3).addAPart(Part.Oboe).addAPart(Part.EnglishHorn));
        Player ami = new Player(new PlayerBuilder().firstNameArea("Ami").lastName("Vardi").type(Type.CONTRACTED).rank(1).addAPart(Part.Clarinet));
        Player benC = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Chen").type(Type.CONTRACTED).rank(1).addAPart(Part.Clarinet));
        Player db = new Player(new PlayerBuilder().firstNameArea("David").lastName("Boutin-Bourque").type(Type.CONTRACTED).rank(3).addAPart(Part.Clarinet).addAPart(Part.BassClarinet));
        Player kdo = new Player(new PlayerBuilder().firstNameArea("KeriAnn").lastName("DiBari-Oberle").type(Type.CONTRACTED).rank(4).addAPart(Part.Clarinet).addAPart(Part.EnglishHorn));
        Player lk = new Player(new PlayerBuilder().firstNameArea("Laura").lastName("Koepke").type(Type.CONTRACTED).rank(1).addAPart(Part.Bassoon));
        Player lel = new Player(new PlayerBuilder().firstNameArea("Sarah Elizabeth").lastName("Lee").type(Type.CONTRACTED).rank(2).addAPart(Part.Bassoon));
        Player cr = new Player(new PlayerBuilder().firstNameArea("Chris").lastName("Rapier").type(Type.CONTRACTED).rank(1).addAPart(Part.Horn));
        Player ma = new Player(new PlayerBuilder().firstNameArea("Mark").lastName("Addleman").type(Type.CONTRACTED).rank(2).addAPart(Part.Horn));
        Player es = new Player(new PlayerBuilder().firstNameArea("Emily").lastName("Shelley").type(Type.CONTRACTED).rank(3).addAPart(Part.Horn));
        Player ba = new Player(new PlayerBuilder().firstNameArea("Bryan").lastName("Adkins").type(Type.CONTRACTED).rank(4).addAPart(Part.Horn));
        Player bs = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Strecker").type(Type.CONTRACTED).rank(5).addAPart(Part.Horn));
        Player gd = new Player(new PlayerBuilder().firstNameArea("Gary").lastName("Davis").type(Type.CONTRACTED).rank(1).addAPart(Part.Trumpet));
        Player da = new Player(new PlayerBuilder().firstNameArea("Douglas").lastName("Amos").type(Type.CONTRACTED).rank(2).addAPart(Part.Trumpet));
        Player mh = new Player(new PlayerBuilder().firstNameArea("Micah").lastName("Holt").type(Type.CONTRACTED).rank(3).addAPart(Part.Trumpet));
        Player wc = new Player(new PlayerBuilder().firstNameArea("Whitney").lastName("Claire").type(Type.CONTRACTED).rank(1).addAPart(Part.Trombone));
        Player sb = new Player(new PlayerBuilder().firstNameArea("Sean").lastName("Bessette").type(Type.CONTRACTED).rank(1).addAPart(Part.BassTrombone));
        Player kh = new Player(new PlayerBuilder().firstNameArea("Ken").lastName("Heinlein").type(Type.CONTRACTED).rank(1).addAPart(Part.Tuba));
        Player bradA = new Player(new PlayerBuilder().firstNameArea("Brad").lastName("Amidon").type(Type.CONTRACTED).rank(1).addAPart(Part.Percussion));
        Player ml = new Player(new PlayerBuilder().firstNameArea("Matt").lastName("Larson").type(Type.CONTRACTED).rank(2).addAPart(Part.Percussion));
        Player mr = new Player(new PlayerBuilder().firstNameArea("Melody").lastName("Rapier").type(Type.CONTRACTED).rank(1).addAPart(Part.Harp));
        Player kj = new Player(new PlayerBuilder().firstNameArea("Ken").lastName("Johnston").type(Type.CONTRACTED).rank(1).addAPart(Part.Violin1));
        Player sls = new Player(new PlayerBuilder().firstNameArea("Sandro").lastName("Leal-Santiesteban").type(Type.CONTRACTED).rank(2).addAPart(Part.Violin1));
        Player jh = new Player(new PlayerBuilder().firstNameArea("Joshua").lastName("Huang").type(Type.CONTRACTED).rank(3).addAPart(Part.Violin1));
        Player melissaH = new Player(new PlayerBuilder().firstNameArea("Melissa").lastName("Hernandez").type(Type.CONTRACTED).rank(4).addAPart(Part.Violin1));
        Player ah = new Player(new PlayerBuilder().firstNameArea("Alexander").lastName("Hettinga").type(Type.CONTRACTED).rank(5).addAPart(Part.Violin1));
        Player stefS = new Player(new PlayerBuilder().firstNameArea("Stefanie").lastName("Schore").type(Type.CONTRACTED).rank(6).addAPart(Part.Violin1));
        Player yk = new Player(new PlayerBuilder().firstNameArea("Yejee").lastName("Kim").type(Type.CONTRACTED).rank(7).addAPart(Part.Violin1));
        Player mp = new Player(new PlayerBuilder().firstNameArea("Maura").lastName("Pelinsky").type(Type.CONTRACTED).rank(8).addAPart(Part.Violin1));
        Player jc = new Player(new PlayerBuilder().firstNameArea("Janice").lastName("Carlson").type(Type.CONTRACTED).rank(9).addAPart(Part.Violin1));
        Player jm = new Player(new PlayerBuilder().firstNameArea("Jonathan").lastName("Moser").type(Type.CONTRACTED).rank(1).addAPart(Part.Violin2));
        Player jenJ = new Player(new PlayerBuilder().firstNameArea("Jennifer").lastName("Jansen").type(Type.CONTRACTED).rank(3).addAPart(Part.Violin2));
        Player tobias = new Player(new PlayerBuilder().firstNameArea("Tobias").lastName("Chisnall").type(Type.CONTRACTED).rank(4).addAPart(Part.Violin2));
        Player jiyeonY = new Player(new PlayerBuilder().firstNameArea("Jiyeon").lastName("Yeo").type(Type.CONTRACTED).rank(5).addAPart(Part.Violin2));
        Player cv = new Player(new PlayerBuilder().firstNameArea("Colleen").lastName("Vanderzyden").type(Type.CONTRACTED).rank(6).addAPart(Part.Violin2));
        Player kf = new Player(new PlayerBuilder().firstNameArea("Karen").lastName("Ferren").type(Type.CONTRACTED).rank(7).addAPart(Part.Violin2));
        Player hl = new Player(new PlayerBuilder().firstNameArea("Howard").lastName("Lyon").type(Type.CONTRACTED).rank(8).addAPart(Part.Violin2));
        Player ee = new Player(new PlayerBuilder().firstNameArea("Emilie").lastName("Engel").type(Type.CONTRACTED).rank(9).addAPart(Part.Violin2));
        Player jiYoung = new Player(new PlayerBuilder().firstNameArea("Ji Young").lastName("Nam").type(Type.CONTRACTED).rank(1).addAPart(Part.Viola));
        Player sy = new Player(new PlayerBuilder().firstNameArea("Si").lastName("Yu").type(Type.CONTRACTED).rank(2).addAPart(Part.Viola));
        Player benS = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Schantz").type(Type.CONTRACTED).rank(3).addAPart(Part.Viola));
        Player eriS = new Player(new PlayerBuilder().firstNameArea("Eri").lastName("Snowden-Rodriguez").type(Type.CONTRACTED).rank(1).addAPart(Part.Cello));
        Player wt = new Player(new PlayerBuilder().firstNameArea("Will").lastName("Teegarden").type(Type.CONTRACTED).rank(2).addAPart(Part.Cello));
        Player nadineS = new Player(new PlayerBuilder().firstNameArea("Nadine").lastName("Sherman").type(Type.CONTRACTED).rank(3).addAPart(Part.Cello));
        Player jeffS = new Player(new PlayerBuilder().firstNameArea("Jeff").lastName("Singler").type(Type.CONTRACTED).rank(4).addAPart(Part.Cello));
        Player bn = new Player(new PlayerBuilder().firstNameArea("Robert").lastName("Nicholson").type(Type.CONTRACTED).rank(5).addAPart(Part.Cello));
        Player jv = new Player(new PlayerBuilder().firstNameArea("Jean").lastName("Verdecchia").type(Type.CONTRACTED).rank(6).addAPart(Part.Cello));
        Player kieranH = new Player(new PlayerBuilder().firstNameArea("Kieran").lastName("Hanlon").type(Type.CONTRACTED).rank(1).addAPart(Part.Bass));
        Player josephH = new Player(new PlayerBuilder().firstNameArea("Joseph").lastName("Hernandez").type(Type.CONTRACTED).rank(2).addAPart(Part.Bass));
        Player tomC = new Player(new PlayerBuilder().firstNameArea("Thomas").lastName("Christopherson").type(Type.CONTRACTED).rank(3).addAPart(Part.Bass));
        Player jamesM = new Player(new PlayerBuilder().firstNameArea("James").lastName("Mohney").type(Type.CONTRACTED).rank(4).addAPart(Part.Bass));
        Player mariaP = new Player(new PlayerBuilder().firstNameArea("Maria").lastName("Park").type(Type.SUB).rank(1).addAPart(Part.Violin1));
        Player mikeChen = new Player(new PlayerBuilder().firstNameArea("Mike").lastName("Chen").type(Type.SUB).rank(1).addAPart(Part.Violin1));
        Player dianaV = new Player(new PlayerBuilder().firstNameArea("Diana").lastName("Pepelea").type(Type.SUB).rank(1).addAPart(Part.Violin1));
        Player samPetrey = new Player(new PlayerBuilder().firstNameArea("Sam").lastName("Petrey").type(Type.SUB).rank(1).addAPart(Part.Violin1));
        Player maijaAnstine = new Player(new PlayerBuilder().firstNameArea("Maija").lastName("Anstine").type(Type.SUB).rank(1).addAPart(Part.Viola));
        Player chrisBlaha = new Player(new PlayerBuilder().firstNameArea("Chris").lastName("Blaha").type(Type.SUB).rank(1).addAPart(Part.Tuba));
        Player erikSundet = new Player(new PlayerBuilder().firstNameArea("Erik").lastName("Sundet").type(Type.SUB).rank(1).addAPart(Part.Trumpet));

        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV,
                samPetrey, maijaAnstine, chrisBlaha, erikSundet));


//given a pp and an index, return all players.
// so, of the chairsToFill on that pp, are there any players in the playersRepo who can sit there?

        Performance testShow1 = new Performance();
        performanceRepo.save(testShow1);

        Piece firstPiece = new PieceBuilder().title("First Piece").build();
        pieceRepo.save(firstPiece);

        PieceOnProgram firstOnShow = new PieceOnProgram(firstPiece, testShow1);
        ppRepo.save(firstOnShow);

        PInChair firstChair = new PInChair(Part.Clarinet, 1);
        List<PInChair> chairs = new ArrayList<>();
        chairs.add(firstChair);
        firstOnShow.setChairsToFill(chairs);

        firstChair.setPlayer(ami);

        int indexToTest = 0;
        List<Player> playersList = new ArrayList<>();
        PInChair chairToCheck = firstOnShow.getChairsToFill().get(indexToTest);
        for (Player player : playerRepo.findAll()) {
            if (!firstOnShow.playerIsOnThis(player) && player.canPlayerSitHere(chairToCheck)) {
                playersList.add(player);
                System.out.println(player.getLastName());
            }
        }

        assertEquals(playersList.size(), 1);


    }
}
