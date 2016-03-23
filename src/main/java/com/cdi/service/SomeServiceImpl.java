/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.service;

import com.cdi.event.ServiceEvent;
import com.cdi.interceptor.Log;
import com.cdi.interceptor.LogInterceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.interceptor.Interceptors;

/**
 *
 * @author jose.rubalcaba
 */
@Interceptors(LogInterceptor.class)
@Named(value = "simple_service")
@RequestScoped
public class SomeServiceImpl implements SomeService{

    @Inject
    private Event<ServiceEvent> event; 
    
    public SomeServiceImpl(){
        
    }
    
    private String HELLO = "Hello fella!";  
    
    @Log
    @Override
    public void service() {
        System.out.println("firing begining event " + new Date().toLocaleString());
        event.fire(new ServiceEvent(new Date().toLocaleString(), ServiceEvent.ServiceStatus.BEGINING));
        System.out.println("firing in_process event " + new Date().toLocaleString());
        event.fire(new ServiceEvent(new Date().toLocaleString(), ServiceEvent.ServiceStatus.IN_PROCESS));
        System.out.println("firing completed event " + new Date().toLocaleString());
        event.fire(new ServiceEvent(new Date().toLocaleString(), ServiceEvent.ServiceStatus.COMPLETED));
    }
    
    public String getHelloConstant(){
        return HELLO; 
    }
}
