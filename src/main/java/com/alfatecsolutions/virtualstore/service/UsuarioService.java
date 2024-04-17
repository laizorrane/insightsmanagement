package com.alfatecsolutions.virtualstore.service;

import com.alfatecsolutions.virtualstore.converter.MapperClass;
import com.alfatecsolutions.virtualstore.dto.UsuarioDto;
import com.alfatecsolutions.virtualstore.entity.Usuario;
import com.alfatecsolutions.virtualstore.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alfatecsolutions.virtualstore.entity.Usuario.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> buscarUsuarios(){
        return repository.findAll();
    }

    public void criar(UsuarioDto usuarioDto) {
        var usuario = MapperClass.converter(usuarioDto, Usuario.class);
        repository.save(usuario);
    }

}
