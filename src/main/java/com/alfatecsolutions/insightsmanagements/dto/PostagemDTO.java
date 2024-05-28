package com.alfatecsolutions.insightsmanagements.dto;

import java.util.Date;

public record PostagemDTO(
        String linkPost, String descricao, Date horaDataPostagem,
        Long totalCurtidas, Long totalComentarios, Long totalComentariosOcultos, Long totalSalvos,
        Long totalCompartilhados, Long totalRespondidos, AcessoInstagramDTO acessoInstagramDTO) {
}