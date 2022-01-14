package com.mscliente.dto;

import com.mscliente.models.ClienteModel;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteDto {

    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique=true)
    private String email;

    public ClienteDto(){

    }

    public ClienteDto(ClienteModel obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
