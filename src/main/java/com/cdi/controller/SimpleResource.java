/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller;

import com.cdi.event.ServiceEvent;
import com.cdi.service.SomeService;
import java.io.IOException;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose.rubalcaba
 */
@WebServlet(name = "SimpleServlet", urlPatterns = { "/simple"})
public class SimpleResource extends HttpServlet{

    @Inject
    private SomeService service; 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calling service interface");
        service.service();
        req.getRequestDispatcher("another.jsp").forward(req, resp);
    }
    
    
}
