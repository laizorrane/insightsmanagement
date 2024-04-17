package com.alfatecsolutions.virtualstore.repository;

import com.alfatecsolutions.virtualstore.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
