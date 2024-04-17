package com.alfatecsolutions.virtualstore.controller;

import com.alfatecsolutions.virtualstore.dto.UsuarioDto;
import com.alfatecsolutions.virtualstore.entity.Usuario;
import com.alfatecsolutions.virtualstore.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    //Implementar HATEOAS e Security

    @Autowired
    private UsuarioService service;


    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarios(){
        return ResponseEntity.ok(service.buscarUsuarios());
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody UsuarioDto usuarioDto){
        service.criar(usuarioDto);
        return ResponseEntity.ok().build();
    }

}
