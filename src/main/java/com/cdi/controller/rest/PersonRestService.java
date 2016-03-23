/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.controller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author jose.rubalcaba
 */
@Path(value = "/rest/persons")
public class PersonRestService {
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public Response getPersons(){
        return Response
            .status(Response.Status.OK)
                .entity(":OKAY:").build(); 
    }
}
