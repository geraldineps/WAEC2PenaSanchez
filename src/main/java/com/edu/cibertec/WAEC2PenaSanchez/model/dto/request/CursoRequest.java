package com.edu.cibertec.WAEC2PenaSanchez.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CursoRequest {
    private Integer idcurso;
    private String nomcurso;
    private String resumen;
    private Date fecharegistro;
    private Integer iddocente;
}
