##  Projeto com Spring Boot

------------

### Path
- path: http://localhost:9001/app/v1.0

### Rotas

------------

###### - Usuarios:
- GET Usuários All: path/usuarios
- GET Usuários ById: path/usuarios/:id
- DELETE Usuários *: path/usuarios/:id
- PUT Usuários *: path/usuarios/:id
```json
 {
    "id": 1,
    "nome": "Nome",
    "email": "email@email.com",
    "senha": "teste123"
}
```
- POST Usuários: path/usuarios
```json
 {
    "nome": "Nome",
    "email": "email@email.com",
    "senha": "teste123"
}
```

------------

###### - Login:
- POST Login: path/login/:id
```json
 {
    "nome": "Nome",
    "email": "email@email.com"
}
```

------------

###### - Categoria:
- GET Categoria All *: path/categorias
- GET Categoria ById  *: path/categorias/:id
- PUT Categoria *: path/categorias/:id
```json
 {
	"nome": "Cozinha"
}
```
- POST Usuários: path/categoria
```json
{
	"nome": "Cozinha"
}
```

------------
###### - Produto:
- GET Produto All  *: path/produtos
- GET Produto ById  *: path/produtos/:id
- DELETE Produto  *: path/produtos/:id
- PUT Usuários  *: path/produtos/:id
```json
{
    "id": 7,    
    "valor": 1530.09
}
```
- POST Produto  *: path/produtos
```json
{
    "descricao": "Freezer",    
    "valor": 2530.09,
    "categoria": [
        {
            "id": 1,
            "nome" : "Eletrônicos"
        }
    ]
}
```

------------


### Anotações

>  * Rotas que necessitam de autenticação 
