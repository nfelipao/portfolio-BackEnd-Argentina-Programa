package com.appl.porfolio.services;

import com.appl.porfolio.exception.UserNotFoundException;
import com.appl.porfolio.models.Usuario;
import com.appl.porfolio.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;
    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo) {this.usuarioRepo = usuarioRepo;}

    public Usuario addUsuario(Usuario usuario) {return usuarioRepo.save(usuario);}
    public List<Usuario> buscarUsuario(){
        return usuarioRepo.findAll();
    }
    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    public void borrarUsuario(Long id){usuarioRepo.deleteById(id);}
    public Usuario buscarUsuarioPorId(Long id){return usuarioRepo.findById(id).orElseThrow(() ->new UserNotFoundException("usuario no encontrado"));}
}
