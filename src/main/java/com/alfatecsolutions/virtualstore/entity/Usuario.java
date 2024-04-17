package com.alfatecsolutions.virtualstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String guid;
    private String nome;
    private String cpf;
    private String senha;
    private String perfil;

    @OneToMany
    @JoinColumn
    private Set<Endereco> enderecos;

    @OneToMany
    @JoinColumn
    private Set<Contato> contatos;


    @PrePersist
    public void criarId(){
        if(StringUtils.isBlank(this.guid)){
            this.guid = UUID.randomUUID().toString();
        }
    }

}
