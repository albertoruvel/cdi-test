/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller;

import com.cdi.dao.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author jose.rubalcaba
 */
@WebServlet(name = "AddPerson", urlPatterns = {"/addPerson"})
public class AddPerson extends HttpServlet {

    @PersistenceContext
    private EntityManager em; 

    @Resource
    private UserTransaction utx;
    
    @Inject
    private transient Logger logger; 
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //dispatch the request to addPerson.jsp 
        request.getRequestDispatcher("addPerson.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //get name 
        String name = request.getParameter("name"); 
        String lastName = request.getParameter("last"); 
        logger.info("Creating person object"); 
        Person p = new Person(name, lastName); 
        try{
            logger.info("begining transaction");
            utx.begin();
            logger.info("persisting person");
            em.persist(p);
            logger.info("commiting transaction");
            utx.commit();
//            logger.info("closing entity manager transaction");
//            em.close(); 
        }catch(Exception ex){
            logger.severe("Got exception: " + ex.getMessage());
            logger.severe("Localized message: " + ex.getLocalizedMessage());
            throw new ServletException(ex.getMessage()); 
        }
        logger.info("Forwarding to jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
