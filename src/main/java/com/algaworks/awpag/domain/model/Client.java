package com.algaworks.awpag.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Entity
//@Table(name = "tb_cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Client {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    public List<Client> listar() {
        var client1 = new Client();
        client1.setId(1L);
        client1.setNome("Boruto");
        client1.setTelefone("28504802542");
        client1.setEmail("boruto@gmail.com");

        var client2 = new Client();
        client2.setId(1L);
        client2.setNome("Boruto");
        client2.setTelefone("28504802542");
        client2.setEmail("boruto@gmail.com");

        return Arrays.asList(client1, client2);
    }

}
