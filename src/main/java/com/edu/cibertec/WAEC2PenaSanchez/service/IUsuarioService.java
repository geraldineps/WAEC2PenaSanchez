package com.edu.cibertec.WAEC2PenaSanchez.service;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioxId(int id);
}
