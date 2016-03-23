/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.interceptor;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;

/**
 *
 * @author jose.rubalcaba
 */
@Interceptor
@Log
public class LogInterceptor {
    
    @Inject
    private Logger logger; 
    
    public LogInterceptor(){
        
    }
    
    @AroundInvoke
    public Object aroundInvoke(InvocationContext cxt)throws Exception{
        Object obj = cxt.getTarget(); 
        logger.info("LogInterceptor aroundInvoke annotated method: " + obj);
        return cxt.proceed(); 
    }
    
}
