package br.com.derich.Meme.controller;

import br.com.derich.Meme.entity.Meme;
import br.com.derich.Meme.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private final RestTemplate restTemplate;

    public MemeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public String logs(@PathVariable Long id) {
        return "Meme ID: " + id;
    }

    @Autowired
    private MemeService memeService;

    @PostMapping
    public Meme cadastroMeme(@RequestBody Meme meme) {
        return memeService.novoMeme(meme);
    }

    @GetMapping
    public List<Meme> encontraTodos() {
        return memeService.encontrarTodos();
    }
}
