package com.alfatecsolutions.virtualstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Data
@Entity
public class Contato {

    @Id
    private String guid;
    private String email;
    private String telefone;


    @PrePersist
    public void criarId(){
        if(StringUtils.isBlank(this.guid)){
            this.guid = UUID.randomUUID().toString();
        }
    }

}
