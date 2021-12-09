package com.example.demo.models;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

public class PlayerBuilder {

    public Type type;
    public int rank;

    @ElementCollection
    public List<Part> parts;

    public Part primaryPart;

    public String firstNameArea;
    public String lastName;
    public String email;
    public String homePhone;
    public String cellPhone;

    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zip;

    public PlayerBuilder firstNameArea(String firstNameArea) {
        if (firstNameArea != null) {
            this.firstNameArea = firstNameArea;
        }
        return this;
    }

    public PlayerBuilder lastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
        return this;
    }

    public PlayerBuilder type(Type type) {
        if (type != null) {
            this.type = type;
        }
        return this;
    }

    public PlayerBuilder rank(int rank) {
        if (rank > 0) {
            this.rank = rank;
        }
        return this;
    }

    public PlayerBuilder addAPart(Part part) {
        if (parts == null) {
            parts = new ArrayList<>();
        }
        if (part != null) {
            parts.add(part);
        }

        return this;
    }


    public PlayerBuilder email(String email) {
        if (email != null) {
            this.email = email;
        }
        return this;
    }

    public PlayerBuilder homePhone(String homePhone) {
        if (homePhone != null) {
            this.homePhone = homePhone;
        }
        return this;
    }

    public PlayerBuilder cellPhone(String cellPhone) {
        if (cellPhone != null) {
            this.cellPhone = cellPhone;
        }
        return this;
    }

    public PlayerBuilder addressLine1(String addressLine1) {
        if (addressLine1 != null) {
            this.addressLine1 = addressLine1;
        }
        return this;
    }

    public PlayerBuilder addressLine2(String addressLine2) {
        if (addressLine2 != null) {
            this.addressLine2 = addressLine2;
        }
        return this;
    }

    public PlayerBuilder city(String city) {
        if (city != null) {
            this.city = city;
        }
        return this;
    }

    public PlayerBuilder state(String state) {
        if (state != null) {
            this.state = state;
        }
        return this;
    }

    public PlayerBuilder zip(String zip) {
        if (zip != null) {
            this.zip = zip;
        }
        return this;
    }


    public Player build() {
        return new Player(this);
    }

}
