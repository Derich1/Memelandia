package br.com.derich.Usuario.controller;

import br.com.derich.Usuario.entity.Usuario;
import br.com.derich.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final RestTemplate restTemplate;

    public UsuarioController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public String logs(@PathVariable Long id) {
        return "Usuário ID: " + id;
    }

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario cadastraUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
}
