package br.com.derich.Usuario.service;

import br.com.derich.Usuario.entity.Usuario;
import br.com.derich.Usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        usuario.setDataCadastro(new Date(System.currentTimeMillis()));
        return usuarioRepository.save(usuario);
    }

    public boolean usuarioExiste(String id) {
        return usuarioRepository.findById(id).isPresent();
    }
}

