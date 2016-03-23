/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.event;

import java.io.Serializable;
import java.util.Observer;
import javax.enterprise.event.Observes;

/**
 *
 * @author jose.rubalcaba
 */

public class ServiceHandler implements Serializable{
    public void handleServiceEvent(@Observes ServiceEvent event){
        System.out.println("handleServiceEvent has fired");
        System.out.println("eventDate: " + event.getDate());
        System.out.println("status: " + event.getStatus().getValue());
    }
}
