package com.quangminh.swing1;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int id;
    private String empCat;
    public FormEvent(Object source) {
        super(source);
    }
    public FormEvent(Object source, String name, String occupation,int id,String empCat) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.id = id;
        this.empCat = empCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public int getId() {return id;}

    public String getEmpCat() {
        return empCat;
    }
}
