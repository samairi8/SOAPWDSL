package com.tp.soapwdsl.web;

import com.tp.soapwdsl.entities.Compte;
import com.tp.soapwdsl.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;

public class CompteSOAPWS {
    @Autowired
    private CompteRepository cptRep;

    @WebMethod
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }


    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @WebMethod
    public Compte save(@WebParam Compte compte) {
        return cptRep.save(compte);
    }

    @WebMethod
    public Compte update(@WebParam Compte compte, @WebParam(name = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @WebMethod
    public void delete(@WebParam(name = "id") Long id) {
        cptRep.deleteById(id);
    }

}


