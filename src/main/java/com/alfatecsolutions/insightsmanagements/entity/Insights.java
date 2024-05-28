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
public class Insights {

    @Id
    private String guid;
    private Long contasAlcancadas;
    private Long contasComEngajamento;
    private Long totalDeSeguidores;

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
