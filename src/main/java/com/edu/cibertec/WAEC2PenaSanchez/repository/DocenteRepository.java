package com.edu.cibertec.WAEC2PenaSanchez.repository;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
