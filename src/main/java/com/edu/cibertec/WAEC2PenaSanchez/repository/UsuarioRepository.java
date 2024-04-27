package com.edu.cibertec.WAEC2PenaSanchez.repository;


import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNomusuario(String nomusuario);

}
