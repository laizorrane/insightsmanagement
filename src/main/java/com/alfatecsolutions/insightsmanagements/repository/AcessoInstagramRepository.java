package com.alfatecsolutions.insightsmanagements.repository;

import com.alfatecsolutions.insightsmanagements.entity.AcessoInstagram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AcessoInstagramRepository extends JpaRepository<AcessoInstagram, String> {

    @Query("Select i from AcessoInstagram i where i.usuario.guid = :idUsuario")
    List<AcessoInstagram> buscarListaInstagramsAssociados(String idUsuario);


    @Query("Select i from AcessoInstagram i " +
            "where i.usuario.guid = :idUsuario " +
            "and (:nome is null or i.nome = :nome) " +
            "and (:username is null or i.username = :username) " +
            "order by i.username asc")
    Page<AcessoInstagram> buscarListaInstagramsAssociados(String idUsuario, String nome, String username, Pageable pageable);

}
