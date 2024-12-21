package br.com.derich.CategoriaMeme.controller;

import br.com.derich.CategoriaMeme.entity.CategoriaMeme;
import br.com.derich.CategoriaMeme.service.CategoriaMemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaMemeController {

    @Autowired
    public CategoriaMemeService categoriaMemeService;

    @GetMapping
    public List<CategoriaMeme> buscaTodos() {
        return categoriaMemeService.buscarTodos();
    }

    @PostMapping
    public CategoriaMeme cadastroCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return categoriaMemeService.cadastrarCategoria(categoriaMeme);
    }
}
