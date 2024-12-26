package br.com.derich.Meme.service;

import br.com.derich.Meme.entity.Meme;
import br.com.derich.Meme.repository.IMemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MemeService {

    @Autowired
    private IMemeRepository memeRepository;

    public List<Meme> buscarTodos() {
        return memeRepository.findAll();
    }

    public Meme cadastrarMeme (Meme meme) {
        meme.setDataCadastro(new Date(System.currentTimeMillis()));
        return memeRepository.save(meme);
    }
}
