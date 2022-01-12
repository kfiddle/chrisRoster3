package com.example.demo.models.piece;

import com.example.demo.enums.Part;
import com.example.demo.models.NumbOnPart;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Piece {

    @Id
    @GeneratedValue
    private Long id;

    private String prefix;
    private String libNumber;
    private String suffix;
    private String composerName;
    private String arranger;
    private String title;
    private String otherName;
    private String publisher;
    private String duration;
    private String instrumentation;
    private String vocalistSoloist;
    private String percBreakdown;
    private String notes;
    private String status;
    private String sign;

    private LocalDate updated;

    @ElementCollection
    private Collection<NumbOnPart> orchestration = new ArrayList<>();

//    @ElementCollection
//    @MapKeyEnumerated
//    private Map<Part, Integer> instrNums = new HashMap<>();

    public Piece() {
    }

    public Piece(PieceBuilder pieceBuilder) {
        prefix = pieceBuilder.prefix;
        libNumber = pieceBuilder.libNumber;
        suffix = pieceBuilder.suffix;
        composerName = pieceBuilder.composerName;
        arranger = pieceBuilder.arranger;
        title = pieceBuilder.title;
        otherName = pieceBuilder.otherName;
        publisher = pieceBuilder.publisher;
        duration = pieceBuilder.duration;
        instrumentation = pieceBuilder.instrumentation;
        vocalistSoloist = pieceBuilder.vocalistSoloist;
        percBreakdown = pieceBuilder.percBreakdown;
        notes = pieceBuilder.notes;
        status = pieceBuilder.status;
        sign = pieceBuilder.sign;
        updated = pieceBuilder.updated;
        orchestration = pieceBuilder.orchestration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setLibNumber(String libNumber) {
        this.libNumber = libNumber;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInstrumentation(String instrumentation) {
        this.instrumentation = instrumentation;
    }

    public void setVocalistSoloist(String vocalistSoloist) {
        this.vocalistSoloist = vocalistSoloist;
    }

    public void setPercBreakdown(String percBreakdown) {
        this.percBreakdown = percBreakdown;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public void setOrchestration(Collection<NumbOnPart> incomingOrchestration) {
        List<NumbOnPart> convertedIncoming = new ArrayList<>(incomingOrchestration);
        Collections.sort(convertedIncoming);
        this.orchestration = convertedIncoming;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComposerName() {
        return composerName;
    }

    public String getDuration() {
        return duration;
    }

    public String getNotes() {
        return notes;
    }

    public String getArranger() {
        return arranger;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getInstrumentation() {
        return instrumentation;
    }

    public String getVocalistSoloist() {
        return vocalistSoloist;
    }

    public String getPercBreakdown() {
        return percBreakdown;
    }

    public String getStatus() {
        return status;
    }

    public String getSign() {
        return sign;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public Collection<NumbOnPart> getOrchestration() {
        return orchestration;
    }

    public void addNumOnPart(NumbOnPart numbOnPart) {
        orchestration.add(numbOnPart);
    }


    public void setAllProps(Piece incoming) {
        if (incoming.getPrefix() != null) {
            prefix = incoming.getPrefix();
        }
        if (incoming.getLibNumber() != null) {
            libNumber = incoming.getLibNumber();
        }
        if (incoming.getSuffix() != null) {
            suffix = incoming.getSuffix();
        }
        if (incoming.getComposerName() != null) {
            composerName = incoming.getComposerName();
        }
        if (incoming.getArranger() != null) {
            arranger = incoming.getArranger();
        }
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getPublisher() != null) {
            publisher = incoming.getPublisher();
        }
        if (incoming.getDuration() != null) {
            duration = incoming.getDuration();
        }

        if (incoming.getInstrumentation() != null) {
            instrumentation = incoming.getInstrumentation();
        }
        if (incoming.getVocalistSoloist() != null) {
            vocalistSoloist = incoming.getVocalistSoloist();
        }
        if (incoming.getPercBreakdown() != null) {
            percBreakdown = incoming.getPercBreakdown();
        }
        if (incoming.getNotes() != null) {
            notes = incoming.getNotes();
        }
        if (incoming.getStatus() != null) {
            status = incoming.getStatus();
        }
        if (incoming.getSign() != null) {
            sign = incoming.getSign();
        }
        if (incoming.getUpdated() != null) {
            updated = incoming.getUpdated();
        }


    }


}

