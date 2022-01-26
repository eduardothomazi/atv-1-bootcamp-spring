package com.eduardothomazi.bootcampSpringAtvOne.resources;

import com.eduardothomazi.bootcampSpringAtvOne.dto.ClientDTO;
import com.eduardothomazi.bootcampSpringAtvOne.entities.Client;
import com.eduardothomazi.bootcampSpringAtvOne.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ClientDTO>> findByPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
        Page<Client> list = service.findPage(page,linesPerPage,direction,orderBy);
        Page<ClientDTO> clientDTO = list.map(obj -> new ClientDTO(obj));
        return ResponseEntity.ok().body(clientDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO obj){
        service.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

}
