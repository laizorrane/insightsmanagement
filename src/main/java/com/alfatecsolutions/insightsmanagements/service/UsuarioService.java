package com.alfatecsolutions.insightsmanagements.service;

import com.alfatecsolutions.insightsmanagements.converter.MapperClass;
import com.alfatecsolutions.insightsmanagements.dto.UsuarioDTO;
import com.alfatecsolutions.insightsmanagements.entity.Usuario;
import com.alfatecsolutions.insightsmanagements.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> buscarUsuarios(){
        return MapperClass.converter(repository.findAll(), UsuarioDTO.class);
    }

    public UsuarioDTO criar(UsuarioDTO usuarioDto) {
        var usuario = MapperClass.converter(usuarioDto, Usuario.class);
        var usuarioSalvo = repository.save(usuario);
        return MapperClass.converter(usuarioSalvo, UsuarioDTO.class);
    }

    public void deletar(String idUsuario) {
        repository.deleteById(idUsuario);
    }

    public UsuarioDTO buscarUsuarioPorId(String idUsuario) {
        var usuario = repository.findById(idUsuario).get();
        return MapperClass.converter(usuario, UsuarioDTO.class);
    }

}
