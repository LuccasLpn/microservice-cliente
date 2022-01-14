package com.mscliente.controllers;

import com.mscliente.dto.ClienteDto;
import com.mscliente.models.ClienteModel;
import com.mscliente.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> insert(@RequestBody @Valid ClienteDto clienteDto) {
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteService.insert(clienteModel);
        return new ResponseEntity<>(clienteModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteModel> findById(@RequestBody @PathVariable long id) {
            ClienteModel clienteModel = clienteService.findById(id);
            return new ResponseEntity<>(clienteModel, HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDto>> findAll(){
        List<ClienteModel> list = clienteService.findAll();
        List<ClienteDto> dto = list.stream().map(ClienteDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }


}
