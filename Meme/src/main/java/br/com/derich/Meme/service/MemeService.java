package br.com.derich.Meme.service;

import br.com.derich.Meme.entity.Meme;
import br.com.derich.Meme.repository.IMemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {

    @Autowired
    private IMemeRepository memeRepository;

    public Meme novoMeme (Meme meme) {
        return memeRepository.save(meme);
    }

    public List<Meme> encontrarTodos() {
        return memeRepository.findAll();
    }
}
