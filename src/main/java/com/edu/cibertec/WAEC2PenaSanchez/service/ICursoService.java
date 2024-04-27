package com.edu.cibertec.WAEC2PenaSanchez.service;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Curso;

import java.util.List;


public interface ICursoService {
    List<Curso> listarCursos();

    void registrarCurso(Curso curso);
}
