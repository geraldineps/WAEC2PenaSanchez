package com.edu.cibertec.WAEC2PenaSanchez.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    @Column(name = "nomdocente")
    private String nomdocente;

    @Column(name = "apedocente")
    private String apedocente;

    @Column(name = "fechnacdocente")
    private Date fechnacdocente;
}
