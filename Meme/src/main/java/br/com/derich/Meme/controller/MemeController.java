package br.com.derich.Meme.controller;

import br.com.derich.Meme.entity.Meme;
import br.com.derich.Meme.service.MemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private static final Logger logger = LoggerFactory.getLogger(MemeController.class);

    @Autowired
    private MemeService memeService;

    @PostMapping
    public Meme cadastroMeme(@RequestBody Meme meme) {
        logger.info("POST /meme - Iniciando cadastro de meme: {}", meme);
        try {
            Meme memeCadastrado = memeService.novoMeme(meme);
            logger.info("POST /meme - Meme cadastrado com sucesso: {}", memeCadastrado);
            return memeCadastrado;
        } catch (Exception e) {
            logger.error("POST /meme - Erro ao cadastrar meme: {}", e.getMessage());
            throw e; // ou outro tipo de tratamento de erro
        }
    }

    @GetMapping
    public List<Meme> encontraTodos() {
        logger.info("GET /meme - Iniciando busca por todos os memes.");
        try {
            List<Meme> memes = memeService.encontrarTodos();
            logger.info("GET /meme - Busca bem-sucedida, total de memes: {}", memes.size());
            return memes;
        } catch (Exception e) {
            logger.error("GET /meme - Erro ao buscar memes: {}", e.getMessage());
            throw e; // ou outro tipo de tratamento de erro
        }
    }
}
