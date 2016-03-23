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
import java.util.List;
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
@WebServlet(name = "Items", urlPatterns = {"/items"})
public class Items extends HttpServlet {

    @PersistenceContext
    private EntityManager em; 
    
    @Resource
    private UserTransaction utx; 
    
    @Inject
    private Object obj; 
    
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
        //get person id 
        Integer personId = Integer.parseInt(request.getParameter("personId")); 
        if(personId == null || personId <= 0)throw new ServletException("No 'personId' parameter found"); 
        //get person 
        Person person = em.find(Person.class, personId); 
        if(person == null)
            throw new ServletException("The person with id " + personId + " was not found"); 
        request.setAttribute("person", person);
        try{
            System.out.println(obj); 
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage()); 
        }
        //get all items 
//        List<Item> items = em.createQuery("SELECT i FROM item i WHERE i.person_id = :personId ")
//                .setParameter("personId", personId)
//                .getResultList(); 
//        request.setAttribute("items", items);
        request.getRequestDispatcher("items.jsp").forward(request, response);
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
