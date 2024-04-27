package com.edu.cibertec.WAEC2PenaSanchez.service;

import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Rol;
import com.edu.cibertec.WAEC2PenaSanchez.model.bd.Usuario;
import com.edu.cibertec.WAEC2PenaSanchez.repository.RolRepository;
import com.edu.cibertec.WAEC2PenaSanchez.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findUserByNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(
                "123456"));
        usuario.setActivo(true);
        //Buscar el rol que le compete al usuario
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioxId(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        usuario.setPassword("");
        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombres(), usuario.getApellidos(),
                usuario.getActivo(), usuario.getIdusuario()
        );
    }


}
