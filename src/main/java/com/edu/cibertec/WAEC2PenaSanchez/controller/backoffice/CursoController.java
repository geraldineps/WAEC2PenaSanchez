package com.edu.cibertec.WAEC2PenaSanchez.controller.backoffice;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Curso;
import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Docente;
import com.edu.cibertec.WAEC2PenaSanchez.model.dto.request.CursoRequest;
import com.edu.cibertec.WAEC2PenaSanchez.model.dto.response.ResultadoResponse;
import com.edu.cibertec.WAEC2PenaSanchez.service.ICursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/curso")
public class CursoController {
    private ICursoService iCursoService;

    @GetMapping("")
    public String formCurso(Model model)
    {
        model.addAttribute("listcurso", iCursoService.listarCursos());
        return "backoffice/curso/frmcurso";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Curso> listCursos() {return iCursoService.listarCursos();}

    @PostMapping("/register")
    @ResponseBody
    public ResultadoResponse registrarCursos(@RequestBody CursoRequest cursoRequest)
    {
        String mensaje = "Curso registrado correctamente";
        boolean respuesta = true;
        try {
            Curso curso = new Curso();
            if(cursoRequest.getIdcurso() > 0) {
                curso.setIdcurso(cursoRequest.getIdcurso());
            }
            curso.setNomcurso(cursoRequest.getNomcurso());
            curso.setResumen(cursoRequest.getResumen());
            curso.setFecharegistro(cursoRequest.getFecharegistro());
            Docente docente = new Docente();
            docente.setIddocente(cursoRequest.getIddocente());
            curso.setDocente(docente);
            iCursoService.registrarCurso(curso);
        } catch (Exception ex){
            mensaje = "Curso no registrado, error en la BD.";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
