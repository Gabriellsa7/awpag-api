package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {
    @GetMapping("/client")
    public List<Client> list() {
        var client = new Client();
        client.setId(1);
        client.setName("Boruto Uzumaki");
        client.setEmail("Boruto@gmail.com");
        client.setPhone("764674342364");

        var client1 = new Client();
        client1.setId(2);
        client1.setName("Sarada Uchiha");
        client1.setEmail("Sarada@gmail.com");
        client1.setPhone("290594285834");

        return Arrays.asList(client, client1);
    }
}
