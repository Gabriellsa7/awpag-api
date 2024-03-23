package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Client;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ClientRepository;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;
    private final CadastroClientService cadastroClientService;

    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento) {
        if (novoParcelamento.getId() != null) {
            throw new NegocioException("Parcelamento a ser criado não deve possuir um código");
        }

        Client client = cadastroClientService.buscar(novoParcelamento.getClient().getId());

        novoParcelamento.setClient(client);
        novoParcelamento.setDataCriacao(LocalDateTime.now());

        return parcelamentoRepository.save(novoParcelamento);
    }

}
