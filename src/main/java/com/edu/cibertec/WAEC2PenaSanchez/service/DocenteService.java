package com.edu.cibertec.WAEC2PenaSanchez.service;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Docente;
import com.edu.cibertec.WAEC2PenaSanchez.repository.DocenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DocenteService implements IDocenteService {

    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> listarDocentes() {
        return docenteRepository.findAll();
    }
}
