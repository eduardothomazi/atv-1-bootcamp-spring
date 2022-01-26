package com.eduardothomazi.bootcampSpringAtvOne.dto;

import com.eduardothomazi.bootcampSpringAtvOne.entities.Client;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Optional;

public class ClientDTO {
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
    public ClientDTO(Client obj) {
        name = obj.getName();
        cpf = obj.getCpf();
        income = obj.getIncome();
        birthDate = obj.getBirthDate();
        children = obj.getChildren();
    }

    public ClientDTO(Optional<Client> obj ) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
