package com.edu.cibertec.WAEC2PenaSanchez.service;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Curso;
import com.edu.cibertec.WAEC2PenaSanchez.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CursoService implements ICursoService{

    private CursoRepository cursoRepository;
    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
