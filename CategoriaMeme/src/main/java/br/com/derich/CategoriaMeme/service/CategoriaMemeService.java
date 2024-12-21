package br.com.derich.CategoriaMeme.service;

import br.com.derich.CategoriaMeme.entity.CategoriaMeme;
import br.com.derich.CategoriaMeme.repository.ICategoriaMemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaMemeService {

    @Autowired
    public ICategoriaMemeRepository categoriaMemeRepository;

    public List<CategoriaMeme> buscarTodos() {
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme cadastrarCategoria(CategoriaMeme categoriaMeme) {
        return categoriaMemeRepository.save(categoriaMeme);
    }
}
