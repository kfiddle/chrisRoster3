package com.example.demo;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.DateTime;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.PerformanceBuilder;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.PieceBuilder;
import com.example.demo.models.player.Player;
import com.example.demo.models.player.PlayerBuilder;
import com.example.demo.repositories.PerformanceRepo;
import com.example.demo.repositories.PieceOnProgramRepo;
import com.example.demo.repositories.PieceRepo;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@Component
public class Populator implements CommandLineRunner {

    @Resource
    PlayerRepo playerRepo;

    @Resource
    PieceRepo pieceRepo;

    @Resource
    PerformanceRepo performanceRepo;

    @Resource
    PieceOnProgramRepo pieceOnProgramRepo;

    @Override
    public void run(String... args) throws Exception {

//        Player leAnne = new Player(new PlayerBuilder().firstNameArea("Leanne").lastName("Wistrom").type(Type.CONTRACTED).rank(1).addAPart(Part.Flute));

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

//        Player ln = new Player("Louis", "Nicolia");

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


        pieceRepo.saveAll(Arrays.asList(new Piece(new PieceBuilder().title("Rapture").composerName("Rouse")),
                new Piece(new PieceBuilder().title("Violin Concerto in D").composerName("Brahms")),
                new Piece(new PieceBuilder().title("Firebird Suite(1945)").composerName("Stravinsky")),
                new Piece(new PieceBuilder().title("The Sorcerer's Apprentice").composerName("Dukas")),
                new Piece(new PieceBuilder().title("Concerto for Organ and Orchestra").composerName("Poulenc")),
                new Piece(new PieceBuilder().title("Symphony in D minor").composerName("Franck")),
                new Piece(new PieceBuilder().title("Along the Western Shore").composerName("Remick-Warren")),
                new Piece(new PieceBuilder().title("Prelude and Liebestod from Tristan und Isolde").composerName("Wagner")),
                new Piece(new PieceBuilder().title("Piano Concerto No. 3").composerName("Rachmaninoff")),
                new Piece(new PieceBuilder().title("Mary Poppins (Full Film)").composerName("Sherman and Sherman")),
                new Piece(new PieceBuilder().title("Star Wars: A New Hope ").composerName("Williams")),
                new Piece(new PieceBuilder().title("New Work based on Harriet Tubman").composerName("Timothy Adams")),
                new Piece(new PieceBuilder().title("Concertino da Camera for Alto Saxophone and Orchestra").composerName("Ibert")),
                new Piece(new PieceBuilder().title("Concerto, Alto Saxophone, op.109, E-flat major").composerName("Glazunov")),
                new Piece(new PieceBuilder().title("Symphony No. 7").composerName("Beethoven")),
                new Piece(new PieceBuilder().title("Rise").composerName("Zhou Tian")),
                new Piece(new PieceBuilder().title("Symphony No.2").composerName("Mahler"))));

        DateTime sym1Date = new DateTime(LocalDate.of(2022, 1, 8), LocalTime.of(8, 0));

        DateTime pops1First = new DateTime(LocalDate.of(2021, 12, 4), LocalTime.of(3, 0));
        DateTime pops1Second = new DateTime(LocalDate.of(2021, 12, 4), LocalTime.of(8, 0));
        DateTime pops2Date = new DateTime(LocalDate.of(2022, 1, 29), LocalTime.of(8, 0));
        DateTime sym2Date = new DateTime(LocalDate.of(2022, 2, 26), LocalTime.of(8, 0));
        DateTime sym3Date = new DateTime(LocalDate.of(2022, 3, 19), LocalTime.of(8, 0));
        DateTime pops3DateFirst = new DateTime(LocalDate.of(2022, 4, 9), LocalTime.of(8, 0));
        DateTime pops3DateSecond = new DateTime(LocalDate.of(2022, 4, 10), LocalTime.of(3, 0));
        DateTime pops4First = new DateTime(LocalDate.of(2022, 4, 30), LocalTime.of(8, 0));
        DateTime pops4Second = new DateTime(LocalDate.of(2022, 5, 1), LocalTime.of(3, 0));
        DateTime sym4Date = new DateTime(LocalDate.of(2022, 5, 14), LocalTime.of(8, 0));
        DateTime pops5Date = new DateTime(LocalDate.of(2022, 6, 12), LocalTime.of(3, 0));
        DateTime sym5Date = new DateTime(LocalDate.of(2022, 6, 26), LocalTime.of(3, 0));

        List<DateTime> pops1Dates = new ArrayList<>();
        pops1Dates.add(pops1First);
        pops1Dates.add(pops1Second);

        List<DateTime> pops3Dates = new ArrayList<>();
        pops3Dates.add(pops3DateFirst);
        pops3Dates.add(pops3DateSecond);

        List<DateTime> pops4Dates = new ArrayList<>();
        pops4Dates.add(pops4First);
        pops4Dates.add(pops4Second);


        Performance pops1 = new PerformanceBuilder().title("Pops 1: Come Home for the Holidays").performanceDates(pops1Dates).build();
        Performance sym1 = new PerformanceBuilder().title("Sym 1: Midori").withDate(sym1Date).build();
        Performance pops2 = new PerformanceBuilder().title("Pops 2: Music of the Knights").withDate(pops2Date).build();
        Performance sym2 = new PerformanceBuilder().title("Sym 2: French / Organ").withDate(sym2Date).build();
        Performance sym3 = new PerformanceBuilder().title("Sym 3: Olga Kern").withDate(sym3Date).build();
        Performance pops3 = new PerformanceBuilder().title("Pops 3: Mary Poppins in Concert").performanceDates(pops3Dates).build();
        Performance pops4 = new PerformanceBuilder().title("Pops 4:Star Wars:A New Hope in Concert").performanceDates(pops4Dates).build();
        Performance sym4 = new PerformanceBuilder().title("Sym 4: Tim Adams / saxophone").withDate(sym4Date).build();
        Performance pops5 = new PerformanceBuilder().title("Pops 5: R&H").withDate(pops5Date).build();
        Performance sym5 = new PerformanceBuilder().title("Sym 5: Mahler 2").withDate(sym5Date).build();


//        Piece test1 = new Piece(new PieceBuilder().title("Christopher Tin"));
//        Piece test2 = new Piece(new PieceBuilder().title("Cool Stuff"));
//
//        pieceRepo.save(test1);
//        pieceRepo.save(test2);
//
//        PieceOnProgram testish1 = new PieceOnProgram(test1);
//        PieceOnProgram testish2 = new PieceOnProgram(test2);
//
//        pieceOnProgramRepo.save(testish1);
//        pieceOnProgramRepo.save(testish2);
//
//        List<Piece> testPieces = new ArrayList<>();
//
//        testPieces.add(test1);
//        testPieces.add(test2);
//
//        Performance sym5 = new Performance(new PerformanceBuilder().title("Sym 5: Mahler 2").withDate(sym5Date).program(testPieces).build());
        performanceRepo.saveAll(Arrays.asList(pops3, pops1, pops2, sym2, sym3, pops4, sym4, pops5, sym5, sym1));


    }
}
