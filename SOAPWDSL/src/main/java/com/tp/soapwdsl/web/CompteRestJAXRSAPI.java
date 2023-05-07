package com.tp.soapwdsl.web;

import com.tp.soapwdsl.entities.Compte;
import com.tp.soapwdsl.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")

public class CompteRestJAXRSAPI {
    @Autowired
    private CompteRepository cptRep;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }


    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getOne(@PathParam(value = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte) {
        return cptRep.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam(value = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam(value = "id") Long id) {
        cptRep.deleteById(id);
    }

}
