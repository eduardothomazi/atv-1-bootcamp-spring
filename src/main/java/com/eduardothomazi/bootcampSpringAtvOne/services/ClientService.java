package com.eduardothomazi.bootcampSpringAtvOne.services;

import com.eduardothomazi.bootcampSpringAtvOne.dto.ClientDTO;
import com.eduardothomazi.bootcampSpringAtvOne.entities.Client;
import com.eduardothomazi.bootcampSpringAtvOne.repositories.ClientRepository;
import com.eduardothomazi.bootcampSpringAtvOne.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        List<Client> list = repository.findAll();
        List<ClientDTO> dtoList = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Optional<Client> obj = repository.findById(id);
        Client dto = obj.orElseThrow(() -> new ResourceNotFoundException("Not found!"));
        return new ClientDTO(dto);
    }

    @Transactional
    public void create(ClientDTO obj){
        Client entity = new Client(obj);
        repository.saveAndFlush(entity);
    }

    @Transactional(readOnly = true)
    public Page<Client> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
