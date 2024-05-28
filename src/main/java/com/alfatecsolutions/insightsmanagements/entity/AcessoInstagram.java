package com.alfatecsolutions.insightsmanagements.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AcessoInstagram {

    @Id
    private String guid;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Usuario usuario;


    @PrePersist
    public void criarId(){
        if(StringUtils.isBlank(this.guid)){
            this.guid = UUID.randomUUID().toString();
        }
    }

}
