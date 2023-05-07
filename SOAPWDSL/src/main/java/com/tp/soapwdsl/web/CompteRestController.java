package com.tp.soapwdsl.web;

import com.tp.soapwdsl.entities.Compte;
import com.tp.soapwdsl.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")

public class CompteRestController {
    @Autowired
    private CompteRepository cptRep;

    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Compte> CompteList() {
        return cptRep.findAll();
    }


    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public Compte getOne(@PathVariable(value = "id") Long id) {
        return cptRep.findById(id).get();
    }

    @PostMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE})

    public Compte save(@RequestBody Compte compte) {
        return cptRep.save(compte);
    }

    @PutMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public Compte update(@RequestBody Compte compte, @PathVariable(value = "id") Long id) {
        compte.setCode(id);
        return cptRep.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public void delete(@PathVariable(value = "id") Long id) {
        cptRep.deleteById(id);
    }

}
