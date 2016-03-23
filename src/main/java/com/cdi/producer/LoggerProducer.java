/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.producer;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author jose.rubalcaba
 */
public class LoggerProducer {
    @Produces
    public Logger produceLogger(InjectionPoint ip){
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
