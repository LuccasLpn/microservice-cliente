package com.mscliente.models;

import com.mscliente.dto.ClienteDto;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

    @Serial
    private  static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Email
    @Column(unique=true)
    private String email;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public ClienteModel(ClienteDto obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
