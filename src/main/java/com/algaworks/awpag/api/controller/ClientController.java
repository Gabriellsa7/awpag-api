package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Client;
import com.algaworks.awpag.domain.repository.ClientRepository;
import com.algaworks.awpag.domain.service.CadastroClientService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private  final CadastroClientService cadastroClientService;
    private final ClientRepository clientRepository;

    @GetMapping
    public List<Client> list() {
        return  clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> find(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()) {
            return  ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Client adicionar(@Valid @RequestBody Client client) {
        return cadastroClientService.salvar(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> atualizar(@PathVariable Long clientId, @Valid @RequestBody Client client) {
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = cadastroClientService.salvar(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        cadastroClientService.excluir(clientId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
    }


}
