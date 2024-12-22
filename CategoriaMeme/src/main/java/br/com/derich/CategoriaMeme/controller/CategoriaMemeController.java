package br.com.derich.CategoriaMeme.controller;

import br.com.derich.CategoriaMeme.entity.CategoriaMeme;
import br.com.derich.CategoriaMeme.service.CategoriaMemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaMemeController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeController.class);

    @Autowired
    public CategoriaMemeService categoriaMemeService;

    @GetMapping
    public List<CategoriaMeme> buscaTodos() {
        logger.info("GET /categorias - Iniciando busca por todas as categorias.");
        try {
            List<CategoriaMeme> categorias = categoriaMemeService.buscarTodos();
            logger.info("GET /categorias - Busca bem-sucedida, total de categorias: {}", categorias.size());
            return categorias;
        } catch (Exception e) {
            logger.error("GET /categorias - Erro ao buscar categorias: {}", e.getMessage());
            throw e; // ou outro tipo de tratamento de erro
        }
    }

    @PostMapping
    public CategoriaMeme cadastroCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        logger.info("POST /categorias - Iniciando cadastro de categoria: {}", categoriaMeme);
        try {
            CategoriaMeme categoriaCadastrada = categoriaMemeService.cadastrarCategoria(categoriaMeme);
            logger.info("POST /categorias - Categoria cadastrada com sucesso: {}", categoriaCadastrada);
            return categoriaCadastrada;
        } catch (Exception e) {
            logger.error("POST /categorias - Erro ao cadastrar categoria: {}", e.getMessage());
            throw e;
        }
    }
}
