package com.example.demo.models;


import com.example.demo.enums.Part;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Embeddable
public class PartsList {

    @ElementCollection
//    private List<Part> list = new ArrayList<>();
    private Collection<String> list = new ArrayList<>();

    public PartsList(Collection<String> list) {
        this.list = list;
    }

    public PartsList() {
    }

    public Collection<String> getList() {
        return list;
    }
}
