/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.test;

import com.cdi.controller.ws.PersonService;
import com.cdi.controller.ws.PersonServiceWS;
import com.cdi.dao.Person;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author jose.rubalcaba
 */
public class PersonServiceTest{
    
    @Test
    public void test()throws MalformedURLException{
        /**Service service = Service.create(new URL("http://localhost:8080/cdiTest/person_service/PersonService?wsdl"), 
                new QName("http://cditest.org/wsdl", "person_service"));
        assertNotNull(service);
        PersonServiceWS person = service.getPort(PersonServiceWS.class); 
        List<Person> persons = person.getPersons();
        assertNotNull(persons); **/
        System.out.println("Should execute person service here");
    }
}
