package com.alfatecsolutions.insightsmanagements.service;

import com.alfatecsolutions.insightsmanagements.converter.MapperClass;
import com.alfatecsolutions.insightsmanagements.dto.AcessoInstagramDTO;
import com.alfatecsolutions.insightsmanagements.dto.filters.AcessoInstagramFilterDTO;
import com.alfatecsolutions.insightsmanagements.entity.AcessoInstagram;
import com.alfatecsolutions.insightsmanagements.repository.AcessoInstagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstagramService {

    private final PagedResourcesAssembler<AcessoInstagramDTO> pagedResourcesAssembler;

    @Autowired
    private AcessoInstagramRepository repository;

    public List<AcessoInstagramDTO> listarInstagrams(String IdUsuario){
       return MapperClass.converter(repository.buscarListaInstagramsAssociados(IdUsuario), AcessoInstagramDTO.class);
    }

    public AcessoInstagramDTO criar(AcessoInstagramDTO instagramDTO){
        var instagram = MapperClass.converter(instagramDTO, AcessoInstagram.class);
        var instagramSalvo = repository.save(instagram);
        return MapperClass.converter(instagramSalvo, AcessoInstagramDTO.class);
    }

    public void deletar(String idInstagram) {
        repository.deleteById(idInstagram);
    }

    public PagedModel<EntityModel<AcessoInstagramDTO>> paginarInstagrams(Pageable pageable, AcessoInstagramFilterDTO filters){
        var pageInstagrams = repository.buscarListaInstagramsAssociados(filters.idUsuario(), filters.nome(), filters.username(), pageable);
        var pageInstagramsDTO = MapperClass.converter(pageInstagrams, AcessoInstagramDTO.class);
        return pagedResourcesAssembler.toModel(pageInstagramsDTO);
    }

}
