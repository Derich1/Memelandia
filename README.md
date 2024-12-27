# Memelândia

Memelândia é um projeto baseado em microsserviços que tem como objetivo oferecer uma plataforma para gerenciar memes e suas categorias. Este sistema foi projetado com escalabilidade, observabilidade e facilidade de manutenção em mente. Cada microsserviço é responsável por uma funcionalidade específica e pode ser gerenciado de forma independente.

## Microsserviços

### 1. **CategoriaMeme**
- Responsável por gerenciar as categorias de memes.
- Permite criar, editar, listar e excluir categorias.

### 2. **Meme**
- Gerencia os memes da plataforma.
- Inclui funcionalidades como criação, edição, exclusão, listagem de memes e também o "meme do dia" onde é retornado um meme aleatório do banco de dados.

### 3. **Usuários**
- Gerencia os dados dos usuários do sistema.
- Suporta cadastro e listagem dos usuários cadastrados.

### 4. **ServiceDiscovery**
- Implementado usando Zookeeper.
- Responsável pela descoberta de serviços, garantindo que os microsserviços possam se comunicar de forma dinâmica e eficiente.

## Arquitetura

- Cada microsserviço tem seu próprio banco de dados MongoDB, garantindo isolamento de dados.

## Observabilidade

Memelândia inclui recursos de observabilidade para monitorar o sistema:

### Logs
- Os microsserviços geram logs úteis para facilitar a identificação de problemas e/ou confirmação de sucesso.

### Métricas
- As métricas podem ser visualizadas utilizando **Grafana** ou diretamente no **Prometheus**.
- Monitoração inclui dados como latência, uso de recursos e volume de requisições.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para criação dos microsserviços.
- **MongoDB**: Banco de dados NoSQL utilizado por cada microsserviço.
- **Zookeeper**: Gerenciamento do ServiceDiscovery.
- **Prometheus e Grafana**: Solução de monitoramento e visualização de métricas.
- **Docker**: Contêinerização dos microsserviços.

## Estrutura do Repositório

- `/CategoriaMeme`: Código-fonte do microsserviço CategoriaMeme.
- `/Meme`: Código-fonte do microsserviço Meme.
- `/Usuario`: Código-fonte do microsserviço Usuários.
- `/service-discovery`: Código-fonte do ServiceDiscovery.
- `/docker-compose.yml`: Arquivo de configuração para orquestração dos contêineres.
