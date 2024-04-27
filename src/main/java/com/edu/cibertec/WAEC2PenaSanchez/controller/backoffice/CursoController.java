package com.edu.cibertec.WAEC2PenaSanchez.controller.backoffice;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Curso;
import com.edu.cibertec.WAEC2PenaSanchez.service.ICursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
