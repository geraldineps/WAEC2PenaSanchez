package com.edu.cibertec.WAEC2PenaSanchez.controller.backoffice;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Usuario;
import com.edu.cibertec.WAEC2PenaSanchez.model.dto.request.UsuarioRequest;
import com.edu.cibertec.WAEC2PenaSanchez.model.dto.response.ResultadoResponse;
import com.edu.cibertec.WAEC2PenaSanchez.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private IUsuarioService iUsuarioService;

    @GetMapping("/usuario")
    public String frmUsuario(Model model){
        model.addAttribute("listaUsuarios",
                iUsuarioService.listarUsuarios());
        return "backoffice/seguridad/formusuario";
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioxId(@PathVariable("id") int id){
        return iUsuarioService.obtenerUsuarioxId(id);
    }
    @PostMapping("/usuario/registrar")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody
                                              UsuarioRequest usuarioRequest){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioRequest.getNombres());
            usuario.setApellidos(usuarioRequest.getApellidos());
            if(usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
                usuario.setActivo(usuarioRequest.getActivo());
                iUsuarioService.actualizarUsuario(usuario);
            }else{
                usuario.setNomusuario(usuarioRequest.getNomusuario());
                usuario.setEmail(usuarioRequest.getEmail());
                iUsuarioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @GetMapping("/usuario/lista")
    @ResponseBody
    public List<Usuario> listarUsuarios(){
        return iUsuarioService.listarUsuarios();
    }




}
