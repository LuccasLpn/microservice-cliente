package com.mscliente.services;

import com.mscliente.models.ClienteModel;
import com.mscliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteModel insert(ClienteModel clienteModel) {
    clienteModel.setId(null);
    clienteModel = clienteRepository.save(clienteModel);
    return clienteModel;
    }

}
