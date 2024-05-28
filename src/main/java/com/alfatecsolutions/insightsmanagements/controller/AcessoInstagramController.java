package com.alfatecsolutions.insightsmanagements.controller;

import com.alfatecsolutions.insightsmanagements.dto.AcessoInstagramDTO;
import com.alfatecsolutions.insightsmanagements.dto.UsuarioDTO;
import com.alfatecsolutions.insightsmanagements.dto.filters.AcessoInstagramFilterDTO;
import com.alfatecsolutions.insightsmanagements.entity.Usuario;
import com.alfatecsolutions.insightsmanagements.service.InstagramService;
import com.alfatecsolutions.insightsmanagements.service.UsuarioService;
import com.alfatecsolutions.insightsmanagements.util.Constantes;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/acesso/instagram")
public class AcessoInstagramController {
    //Implementar HATEOAS e Security

    @Autowired
    private InstagramService service;


    @GetMapping("/idUsuario")
    public ResponseEntity<List<AcessoInstagramDTO>> buscarInstagrams(@RequestHeader("idUsuario") String id){
        return ResponseEntity.ok(service.listarInstagrams(id));
    }

    @PostMapping
    public ResponseEntity<AcessoInstagramDTO> criar(@RequestBody AcessoInstagramDTO instagramDTO){
        return ResponseEntity.ok(service.criar(instagramDTO));
    }

    @PutMapping
    public ResponseEntity<AcessoInstagramDTO> editar(@RequestBody AcessoInstagramDTO instagramDTO){
        return ResponseEntity.ok(service.criar(instagramDTO));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@RequestHeader("id") String id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<PagedModel<EntityModel<AcessoInstagramDTO>>> listarInstagramsPaginado(@PageableDefault(size = Constantes.PAGEABLE_DEFAULT) Pageable pageable,
                                                                                                AcessoInstagramFilterDTO filterDTO){
        return new ResponseEntity<>(service.paginarInstagrams(pageable, filterDTO), HttpStatus.OK);
    }

}
