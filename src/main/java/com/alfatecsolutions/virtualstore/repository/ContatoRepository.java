package com.alfatecsolutions.virtualstore.repository;

import com.alfatecsolutions.virtualstore.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, String> {
}
