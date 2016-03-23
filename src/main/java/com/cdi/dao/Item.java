/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jose.rubalcaba
 */
@Table(name = "item", schema = "sample")
@Entity(name = "item")
public class Item {
    
       @Id
       @Column(name = "id")
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id; 
       
       @NotNull(message = "Name must not be null")
       @Column(name = "name")
       private String name; 
       
       @NotNull
       @Column(name="person_id")
       private int personId; 
       
    public Item() {
    }

    public Item(String name, Person person) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int person) {
        this.personId = person;
    }
       
       
       
}
