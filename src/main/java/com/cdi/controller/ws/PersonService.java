/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller.ws;

import com.cdi.dao.Person;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose.rubalcaba
 */
@Stateless
@WebService(serviceName = "person_service", 
        portName = "services", 
        targetNamespace = "http://cditest.org/wsdl", 
        endpointInterface = "com.cdi.controller.ws.PersonServiceWS")
public class PersonService implements PersonServiceWS{
    
    @PersistenceContext
    private EntityManager em; 
    
    @Inject
    private transient Logger logger; 
    
    public PersonService(){
        //logger.info("PersonService constructor");
    }
    
    @PostConstruct
    public void postConstruct(){
        //logger.info("PersonService postConstruct method");
    }
    
    
    
   @Override
    public List<Person> getPersons(){
       List<Person> persons = em.createQuery("SELECT p from person p")
               .getResultList(); 
       return persons; 
    }
}
