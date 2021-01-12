package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Acounting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;

    @Column
      private int telnum;

    @Column
      private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelnum() {
        return telnum;
    }

    public void setTelnum(int telnum) {
        this.telnum = telnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
