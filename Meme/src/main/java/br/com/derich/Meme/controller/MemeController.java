package br.com.derich.Meme.controller;

import br.com.derich.Meme.client.ICategoriaClient;
import br.com.derich.Meme.client.IUsuarioClient;
import br.com.derich.Meme.entity.Meme;
import br.com.derich.Meme.service.MemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private static final Logger logger = LoggerFactory.getLogger(MemeController.class);

    @Autowired
    private MemeService memeService;

    @Autowired
    private IUsuarioClient usuarioClient;

    @Autowired
    private ICategoriaClient categoriaClient;

    public MemeController(MemeService memeService, IUsuarioClient usuarioClient) {
        this.memeService = memeService;
        this.usuarioClient = usuarioClient;
    }

    @PostMapping
    public Meme cadastroMeme(@RequestBody Meme meme) {
        logger.info("POST /meme - Iniciando cadastro de meme: {}", meme);
        try {
            if (meme.getUserId() == null) {
                logger.error("O usuário não pode ser nulo");
                throw new IllegalArgumentException("O usuário não pode ser nulo");
            }

            usuarioClient.verificarUsuario(meme.getUserId());
            categoriaClient.verificarCategoria(meme.getCategoriaId());

            Meme memeCadastrado = memeService.cadastrarMeme(meme);
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
            List<Meme> memes = memeService.buscarTodos();
            logger.info("GET /meme - Busca bem-sucedida, total de memes: {}", memes.size());
            return memes;
        } catch (Exception e) {
            logger.error("GET /meme - Erro ao buscar memes: {}", e.getMessage());
            throw e; // ou outro tipo de tratamento de erro
        }
    }

    @GetMapping("/memedodia")
    public Meme memeAleatorio() {
        logger.info("GET /memedodia - Iniciando busca pelo meme do dia.");

        List<Meme> memes = memeService.buscarTodos();

        if (memes.isEmpty()) {
            logger.info("Não há memes cadastrados");
        }

        // Gera um índice aleatório
        Random random = new Random();
        int index = random.nextInt(memes.size());

        logger.info("GET /memedodia - Busca concluída com sucesso!.");
        return memes.get(index);
    }
}
