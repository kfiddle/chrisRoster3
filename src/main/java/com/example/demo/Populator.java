package com.example.demo;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import com.example.demo.models.PlayerBuilder;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;


@Component
public class Populator implements CommandLineRunner {

    @Resource
    PlayerRepo playerRepo;

    @Override
    public void run(String... args) throws Exception {

        Player leAnne = new Player(new PlayerBuilder().firstNameArea("Leanne").lastName("Wistrom").type(Type.CONTRACTED).rank(1).addAPart(Part.Flute));
        Player seanG = new Player(new PlayerBuilder().firstNameArea("Sean").lastName("Gabriel").type(Type.CONTRACTED).rank(2).addAPart(Part.Flute));
        Player danna = new Player(new PlayerBuilder().firstNameArea("Danna").lastName("Sundet").type(Type.CONTRACTED).rank(1).addAPart(Part.Oboe));
        Player heatherS = new Player(new PlayerBuilder().firstNameArea("Heather").lastName("Story").type(Type.CONTRACTED).rank(2).addAPart(Part.Oboe));
        Player sarahH = new Player(new PlayerBuilder().firstNameArea("Sarah").lastName("Hamilton").type(Type.CONTRACTED).rank(3).addAPart(Part.Oboe).addAPart(Part.EnglishHorn));
        Player ami = new Player(new PlayerBuilder().firstNameArea("Ami").lastName("Vardi").type(Type.CONTRACTED).rank(1).addAPart(Part.Clarinet));
        Player benC = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Chen").type(Type.CONTRACTED).rank(2));

        Player db = new Player("David", "Boutin-Bourque");
        Player kdo = new Player("KeriAnn", "DiBari-Oberle");
        Player lk = new Player("Laura", "Laura Koepke");
        Player lel = new Player("Sarah Elizabeth", "Lee");
        Player cr = new Player("Chris", "Rapier");
        Player ma = new Player("Mark", "Addleman");
        Player es = new Player("Emily", "Shelley");
        Player ba = new Player("Bryan", "Adkins");
        Player bs = new Player("Benjamin", "Strecker");
        Player gd = new Player("Gary", "Davis");
        Player da = new Player("Douglas", "Amos");
        Player mh = new Player("Micah", "Holt");
        Player wc = new Player("Whitney", "Claire");
        Player sb = new Player("Sean", "Bessette");
        Player kh = new Player("Ken", "Heinlein");
        Player bradA = new Player("Brad", "Amidon");
        Player ml = new Player("Matt", "Larson");
        Player mr = new Player("Melody", "Rapier");

        Player kj = new Player("Ken", "Johnston");
        Player sls = new Player("Sandro", "Leal-Santiesteban");
        Player jh = new Player("Joshua", "Huang");
        Player melissaH = new Player("Melissa", "Hernandez");
        Player ah = new Player("Alexander", "Hettinga");
        Player stefS = new Player("Stefanie", "Schore");
        Player yk = new Player("Yejee", "Kim");
        Player mp = new Player("Maura", "Pelinsky");
        Player jc = new Player("Janice", "Carlson");

        Player jm = new Player("Jonathan", "Moser");
        Player jenJ = new Player("Jennifer", "Jansen");
        Player tobias = new Player("Tobias", "Chisnall");
        Player jiyeonY = new Player("Jiyeon", "Yeo");
        Player cv = new Player("Colleen", "Vanderzyden");
        Player kf = new Player("Karen", "Ferren");
        Player hl = new Player("Howard", "Lyon");
        Player ln = new Player("Louis", "Nicolia");
        Player ee = new Player("Emilie", "Engel");

        Player jiYoung = new Player("Ji Young", "Nam");
        Player sy = new Player("Si", "Yu");
        Player benS = new Player("Benjamin", "Schantz");

        Player eriS = new Player("Eri", "Snowden-Rodriguez");
        Player wt = new Player("Will", "Teegarden");
        Player nadineS = new Player("Nadine", "Sherman");
        Player jeffS = new Player("Jeff", "Singler");

        Player bn = new Player("Robert ", "Nicholson");
        Player jv = new Player("Jean ", "Verdecchia");

        Player kieranH = new Player("Kieran", "Hanlon");
        Player josephH = new Player("Joseph", "Hernandez");
        Player tomC = new Player("Thomas", "Christopherson");
        Player jamesM = new Player("James", "Mohney");

        Player mariaP = new Player("Maria", "Park");
        Player mikeChen = new Player("Mike", "Chen");
        Player dianaV = new Player("Diana", "Pepelea");

        playerRepo.saveAll(Arrays.asList(db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));

        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));


        Player samPetrey = new Player("Sam", "Petrey");
        Player maijaAnstine = new Player("Maija", "Anstine");
        Player chrisBlaha = new Player("Chris", "Blaha");
        Player erikSundet = new Player("Erik", "Sundet");


        samPetrey.setType(Type.SUB);
        maijaAnstine.setType(Type.SUB);
        chrisBlaha.setType(Type.SUB);
        erikSundet.setType(Type.SUB);

        samPetrey.addPart(Part.Violin1);
        maijaAnstine.addPart(Part.Viola);
        chrisBlaha.addPart(Part.Tuba);
        erikSundet.addPart(Part.Trumpet);

        playerRepo.saveAll(Arrays.asList(samPetrey, maijaAnstine, chrisBlaha, erikSundet));


    }
}
