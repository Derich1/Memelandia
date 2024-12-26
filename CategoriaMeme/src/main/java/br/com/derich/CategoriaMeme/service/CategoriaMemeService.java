package br.com.derich.CategoriaMeme.service;

import br.com.derich.CategoriaMeme.entity.CategoriaMeme;
import br.com.derich.CategoriaMeme.repository.ICategoriaMemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CategoriaMemeService {

    @Autowired
    public ICategoriaMemeRepository categoriaMemeRepository;

    public List<CategoriaMeme> buscarTodos() {
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme cadastrarCategoria(CategoriaMeme categoriaMeme) {
        categoriaMeme.setDataCadastro(new Date(System.currentTimeMillis()));
        return categoriaMemeRepository.save(categoriaMeme);
    }

    public boolean categoriaExiste(String id) {
        return categoriaMemeRepository.findById(id).isPresent();
    }
}
