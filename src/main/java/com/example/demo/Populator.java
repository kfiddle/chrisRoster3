package com.example.demo;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
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


        Player leAnne = new Player("Leanne", "Wistrom");
        Player seanG = new Player("Sean", "Gabriel");
        Player danna = new Player("Danna", "Sundet");
        Player heatherS = new Player("Heather", "Storey");
        Player sarahH = new Player("Sarah", "Hamilton");
        Player ami = new Player("Ami", "Vardi");
        Player benC = new Player("Benjamin", "Chen");
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

        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));

        for (Player player : playerRepo.findAll()) {
            player.setType(Type.CONTRACTED);
        }
        leAnne.addPart(Part.Flute);
        leAnne.setRank(1);
        seanG.addPart(Part.Flute);
        seanG.setRank(2);

        danna.addPart(Part.Oboe);
        danna.setRank(1);
        heatherS.addPart(Part.Oboe);
        heatherS.setRank(2);

        sarahH.addPart(Part.Oboe);
        sarahH.setRank(3);
        sarahH.addPart(Part.EnglishHorn);

        ami.addPart(Part.Clarinet);
        ami.setRank(1);

        benC.addPart(Part.Clarinet);
        benC.setRank(2);

        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));


    }
}
