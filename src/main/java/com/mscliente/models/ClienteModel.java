package com.mscliente.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;

@Data
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
    private String email;

    

}
