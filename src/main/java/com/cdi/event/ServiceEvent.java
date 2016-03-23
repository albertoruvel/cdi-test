/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.event;

import java.io.Serializable;
import javax.enterprise.event.Event;

/**
 *
 * @author jose.rubalcaba
 */
public class ServiceEvent implements Serializable{
    private String date; 
    private ServiceStatus status; 
    
    public ServiceEvent(){
        
    }
    
    public ServiceEvent(String date, ServiceStatus status){
        this.date = date; 
        this.status = status; 
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
    
    
    
    public static enum ServiceStatus{
        BEGINING("service begining"), IN_PROCESS("service in process"), COMPLETED("service completed");
        
        String value; 
        
        ServiceStatus(String val){
            this.value = val; 
        }
        
        public String getValue(){
            return value; 
        }
    }
}
