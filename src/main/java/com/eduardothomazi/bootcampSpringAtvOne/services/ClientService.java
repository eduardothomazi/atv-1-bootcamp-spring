package com.eduardothomazi.bootcampSpringAtvOne.services;

import com.eduardothomazi.bootcampSpringAtvOne.dto.ClientDTO;
import com.eduardothomazi.bootcampSpringAtvOne.entities.Client;
import com.eduardothomazi.bootcampSpringAtvOne.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<ClientDTO> findAll(){
        List<Client> list = repository.findAll();
        List<ClientDTO> dtoList = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return dtoList;
    }

    public ClientDTO findById(Long id){
        Client obj = repository.getById(id);
        ClientDTO dto = new ClientDTO(obj);
        return dto;
    }

    public Client create(Client obj){
       return repository.saveAndFlush(obj);
    }
}
