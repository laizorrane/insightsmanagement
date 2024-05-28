package com.alfatecsolutions.insightsmanagements.controller;

import com.alfatecsolutions.insightsmanagements.dto.UsuarioDTO;
import com.alfatecsolutions.insightsmanagements.entity.Usuario;
import com.alfatecsolutions.insightsmanagements.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    //Implementar HATEOAS e Security

    @Autowired
    private UsuarioService service;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
        return ResponseEntity.ok(service.buscarUsuarios());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO usuarioDto){
        return ResponseEntity.ok(service.criar(usuarioDto));
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDto){
        return ResponseEntity.ok(service.criar(usuarioDto));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@RequestHeader("id") String id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }


}
