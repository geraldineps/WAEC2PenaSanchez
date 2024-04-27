package com.edu.cibertec.WAEC2PenaSanchez.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    @Column(name = "nomcurso")
    private String nomcurso;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "fecharegistro")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecharegistro;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    private Docente docente;
}
