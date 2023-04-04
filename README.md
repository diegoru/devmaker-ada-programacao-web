<div align="center"><img src="https://i.postimg.cc/3JKXXYzt/bnn-adabook.jpg"</div>

<div style="align:center; text-align:center;"><h1>Projeto Final Programação Web II - DevMaker 2</h1></div>

Criação de uma API de livraria, consumindo a Google Books API.




![](https://i.postimg.cc/NjvwJC7C/uml-adabook.jpg)

### Autores

## Listar

```json
'GET' http:localhost:8080/autores
```

**Resposta**

```json
[
	{
		"id": 1,
		"nome": "Robert C. Martin"
	},
	{
		"id": 2,
		"nome": "Eric Evans"
	},
	{
		"id": 3,
		"nome": "Martin Fowler"
	}
]
```

`200 Ok`

## Buscar por id

```json
'GET' http:localhost:8080/autores/1

{
	"id": 1,
	"nome": "Robert C. Martin"
}
```

`200 Ok`

## Adicionar

```json
'POST' http:localhost:8080/autores

{
	"nome": "Sandra Pulga"
}
```

**Resposta**

```json
{
	"id": 4,
	"nome": "Sandra Pulga"
}
```

**`201 Created`**

## Alterar

```json
'PUT' http:localhost:8080/autores/4

{
	"nome": "Sandra Puga"
}
```

**`200 Ok`**

## Remover

```json
'DELETE' localhost:8080/autores/4
```

**`204 No Content`**