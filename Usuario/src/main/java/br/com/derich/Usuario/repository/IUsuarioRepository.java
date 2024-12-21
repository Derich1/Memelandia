package br.com.derich.Usuario.repository;

import br.com.derich.Usuario.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepository extends MongoRepository<Usuario, String> {
}
