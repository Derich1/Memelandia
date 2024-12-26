package br.com.derich.Meme.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Url = http://<nome-do-container>:<porta-do-microsserviço>/endpoint-da-API
@FeignClient(name = "categoria-service", url = "http://categoria-meme:8081/categorias")
public interface ICategoriaClient {

    @GetMapping("/{id}")
    void verificarCategoria(@PathVariable String id);
}
