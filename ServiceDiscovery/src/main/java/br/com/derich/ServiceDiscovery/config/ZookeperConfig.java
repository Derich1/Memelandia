package br.com.derich.ServiceDiscovery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZookeperConfig {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discover-services")
    public List<String> discoverServices() {
        return discoveryClient.getServices();  // Retorna a lista de serviços registrados
    }
}
