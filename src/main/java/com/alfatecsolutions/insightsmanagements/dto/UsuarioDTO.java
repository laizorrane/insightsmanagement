package com.alfatecsolutions.insightsmanagements.dto;

import java.util.Set;

public record UsuarioDTO(String nome, String cpf, String senha, PerfilDTO perfil, Set<AcessoInstagramDTO> acessoInstagramDTO) {
}
