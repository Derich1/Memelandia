package br.com.derich.Meme.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Url = http://<nome-do-container>:<porta-do-microsserviço>/endpoint-da-API
@FeignClient(name = "usuario-service", url = "http://usuario:8083/usuarios")
public interface IUsuarioClient {

    @GetMapping("/{id}")
    void verificarUsuario(@PathVariable String id);

}
