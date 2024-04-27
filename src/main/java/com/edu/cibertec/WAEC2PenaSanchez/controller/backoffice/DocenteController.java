package com.edu.cibertec.WAEC2PenaSanchez.controller.backoffice;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Docente;
import com.edu.cibertec.WAEC2PenaSanchez.service.IDocenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/docente")
public class DocenteController {
    private IDocenteService iDocenteService;

//    @GetMapping("/list")
//    public String listarDocentes(Model model)
//    {
//        model.addAttribute("docentes", iDocenteService.listarDocentes());
//        return "backoffice/Docente/frmdocente";
//    }

    @GetMapping("/get")
    @ResponseBody
    public List<Docente> listDocente() {return iDocenteService.listarDocentes();}
}
