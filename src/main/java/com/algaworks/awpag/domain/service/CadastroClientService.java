package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Client;
import com.algaworks.awpag.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client salvar(Client client) {
        boolean emailUsed = clientRepository.findByEmail(client.getEmail()).filter(c -> !c.equals(client)).isPresent();
        if(emailUsed) {
            throw new NegocioException("Já existe um client cadastrado com esse e-mail");
        }
        return  clientRepository.save(client);
    }

    @Transactional
    public void excluir(Long clientId) {
        clientRepository.deleteById(clientId);
    }

}
