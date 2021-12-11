package com.example.demo.models;

import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class PieceBuilder {

    public String prefix;
    public String libNumber;
    public String suffix;
    public String composerName;
    public String arranger;
    public String title;
    public String otherName;
    public String publisher;
    public String duration;
    public String instrumentation;
    public String vocalistSoloist;
    public String percBreakdown;
    public String notes;
    public String status;
    public String sign;
    public LocalDate updated;

    @ElementCollection
    public Collection<NumbOnPart> orchestration;


    public PieceBuilder() {
        orchestration = new ArrayList<>();
    }

    public PieceBuilder orchestration(Collection<NumbOnPart> numbOnParts) {
        if (numbOnParts != null) {
            this.orchestration = numbOnParts;
        }
        return this;
    }

    public PieceBuilder prefix(String prefix) {
        if (prefix != null) {
            this.prefix = prefix;
        }
        return this;
    }

    public PieceBuilder libNumber(String libNumber) {
        if (libNumber != null) {
            this.libNumber = libNumber;
        }
        return this;
    }

    public PieceBuilder suffix(String suffix) {
        if (suffix != null) {
            this.suffix = suffix;
        }
        return this;
    }

    public PieceBuilder composerName(String composerName) {
        if (composerName != null) {
            this.composerName = composerName;
        }
        return this;
    }

    public PieceBuilder arranger(String arranger) {
        if (arranger != null) {
            this.arranger = arranger;
        }
        return this;
    }

    public PieceBuilder title(String title) {
        if (title != null) {
            this.title = title;
        }
        return this;
    }

    public PieceBuilder otherName(String otherName) {
        if (otherName != null) {
            this.otherName = otherName;
        }
        return this;
    }

    public PieceBuilder publisher(String publisher) {
        if (publisher != null) {
            this.publisher = publisher;
        }
        return this;
    }

    public PieceBuilder duration(String duration) {
        if (duration != null) {
            this.duration = duration;
        }
        return this;
    }

    public PieceBuilder instrumentation(String instrumentation) {
        if (instrumentation != null) {
            this.instrumentation = instrumentation;
        }
        return this;
    }

    public PieceBuilder vocalistSoloist(String vocalistSoloist) {
        if (vocalistSoloist != null) {
            this.vocalistSoloist = vocalistSoloist;
        }
        return this;
    }

    public PieceBuilder percBreakdown(String percBreakdown) {
        if (percBreakdown != null) {
            this.percBreakdown = percBreakdown;
        }
        return this;
    }

    public PieceBuilder notes(String notes) {
        if (notes != null) {
            this.notes = notes;
        }
        return this;
    }

    public PieceBuilder status(String status) {
        if (status != null) {
            this.status = status;
        }
        return this;
    }

    public PieceBuilder sign(String sign) {
        if (sign != null) {
            this.sign = sign;
        }
        return this;
    }

    public PieceBuilder updated(LocalDate updated) {
        if (updated != null) {
            this.updated = updated;
        }
        return this;
    }








}
