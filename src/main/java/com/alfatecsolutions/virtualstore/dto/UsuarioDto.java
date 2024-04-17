package com.alfatecsolutions.virtualstore.dto;

import java.util.Set;

public record UsuarioDto(String nome, String cpf, String senha, String perfil, Set<EnderecoDto> enderecos, Set<ContatoDto> contatos) {
}
