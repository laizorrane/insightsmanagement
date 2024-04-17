package com.alfatecsolutions.virtualstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Data
@Entity
public class Endereco {

    @Id
    private String guid;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;
    private int numero;
    private String complemento;


    @PrePersist
    public void criarId(){
        if(StringUtils.isBlank(this.guid)){
            this.guid = UUID.randomUUID().toString();
        }
    }

}
