package com.alfatecsolutions.insightsmanagements.repository;

import com.alfatecsolutions.insightsmanagements.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
