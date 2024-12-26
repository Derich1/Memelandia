package br.com.derich.Usuario.controller;

import br.com.derich.Usuario.entity.Usuario;
import br.com.derich.Usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Void> verificarUsuario(@PathVariable String id) {
        if (usuarioService.usuarioExiste(id)) {
            logger.info("Id do usuário foi encontrado.");
            return ResponseEntity.ok().build();
        } else {
            logger.info("Id do usuário não foi encontrado.");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuario cadastraUsuario(@RequestBody Usuario usuario) {
        logger.info("POST /usuarios - Iniciando cadastro de usuário: {}", usuario);
        try {
            Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
            logger.info("POST /usuarios - Usuário cadastrado com sucesso: {}", usuarioCadastrado);
            return usuarioCadastrado;
        } catch (Exception e) {
            logger.error("POST /usuarios - Erro ao cadastrar usuário: {}", e.getMessage());
            throw e; // ou outro tipo de tratamento de erro
        }
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        logger.info("GET /usuarios - Iniciando busca por todos os usuários.");
        try {
            List<Usuario> usuarios = usuarioService.buscarTodos();
            logger.info("GET /usuarios - Busca bem-sucedida, total de usuários: {}", usuarios.size());
            return usuarios;
        } catch (Exception e) {
            logger.error("GET /usuarios - Erro ao buscar usuários: {}", e.getMessage());
            throw e;
        }
    }
}
