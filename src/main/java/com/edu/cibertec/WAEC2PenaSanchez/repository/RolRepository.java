package com.edu.cibertec.WAEC2PenaSanchez.repository;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nombrerol);

}
