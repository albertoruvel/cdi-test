/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jose.rubalcaba
 */
@Table(name = "person", schema = "sample")
@Entity(name = "person")
public class Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @NotNull(message = "The person name must not be null")
    @Column(name = "name", updatable = true, length = 100)
    private String name; 
    
    @NotNull(message = "The person last name must not be null")
    @Column(name = "last", updatable = true, length = 100)
    private String last; 
    
    
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Item.class)
    //@JoinColumn(name = "person_id", table = "item")
    private Set<Item> items; 
    
    
    public Person(){
        //items = new HashSet<Item>(); 
    }

    public Person(int id, String name, String last) {
        this.id = id;
        this.name = name;
        this.last = last;
    }

    public Person(String name, String last) {
        this.name = name;
        this.last = last;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    
    
}
