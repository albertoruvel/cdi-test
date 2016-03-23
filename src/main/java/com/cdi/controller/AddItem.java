/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller;

import com.cdi.dao.Item;
import com.cdi.dao.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.transaction.UserTransaction;

/**
 *
 * @author jose.rubalcaba
 */
@ServletSecurity(value=@HttpConstraint)
@WebServlet(name = "AddItem", urlPatterns = {"/addItem"})
public class AddItem extends HttpServlet{
    
    
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
        Integer personId = Integer.parseInt(request.getParameter("personId"));
        if(personId == null || personId <= 0)
            throw new ServletException("No person id has been obtained");  
        else{
            
            //get person 
            
            Person person = em.find(Person.class, personId); 
            request.setAttribute("person", person);
            request.getRequestDispatcher("addItem.jsp").forward(request, response);
        }
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
        //get the person id 
        Integer personId = Integer.parseInt(request.getParameter("personId")); 
        String itemName = request.getParameter("itemName"); 
        //get person 
        logger.info("finding person with id " + personId); 
        Person person = em.find(Person.class, personId); 
        //create a new item 
        logger.info("Creating new item"); 
        Item item = new Item();
        item.setName(itemName);
        item.setPersonId(personId);
        logger.info("Inserting new item");
        //add the item to the person 
        //person.getItems().add(item); 
        try{
            utx.begin();
            logger.info("Merging entity manager");
            em.persist(item); 
            logger.info("Commiting changes"); 
            utx.commit();
        }catch(Exception ex){
            logger.severe("Exception message: " + ex.getMessage());
            throw new ServletException(ex.getMessage()); 
        }
        request.setAttribute("personId", personId);
        response.sendRedirect("items?personId=" + personId);
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
