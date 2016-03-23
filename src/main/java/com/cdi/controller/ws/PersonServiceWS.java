/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller.ws;

import com.cdi.dao.Person;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author jose.rubalcaba
 */
@WebService(targetNamespace = "http://cditest.org/wsdl")
public interface PersonServiceWS {
    @WebMethod
    public List<Person> getPersons(); 
}
