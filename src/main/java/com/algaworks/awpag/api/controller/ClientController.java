package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/clientes")
    public List<Client> list() {
        return manager.createQuery("from Cliente", Client.class)
                .getResultList();
    }
}
