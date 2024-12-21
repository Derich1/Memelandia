package br.com.derich.CategoriaMeme.repository;

import br.com.derich.CategoriaMeme.entity.CategoriaMeme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICategoriaMemeRepository extends MongoRepository<CategoriaMeme, String> {
}
