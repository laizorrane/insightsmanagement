package com.alfatecsolutions.insightsmanagements.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    private String guid;
    private String linkPost;
    private String descricao;
    private Date horaDataPostagem;
    private Long totalCurtidas;
    private Long totalComentarios;
    private Long totalComentariosOcultos;
    private Long totalSalvos;
    private Long totalCompartilhados;
    private Long totalRespondidos;

    @ManyToOne
    @JoinColumn
    private AcessoInstagram acessoInstagram;


    @PrePersist
    public void criarId(){
        if(StringUtils.isBlank(this.guid)){
            this.guid = UUID.randomUUID().toString();
        }
    }

}
