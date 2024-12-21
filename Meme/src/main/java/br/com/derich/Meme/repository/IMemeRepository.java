package br.com.derich.Meme.repository;

import br.com.derich.Meme.entity.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMemeRepository extends MongoRepository<Meme, String> {
}
