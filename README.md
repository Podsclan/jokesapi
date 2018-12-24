Access one random joke -> /jokesAPI -> GET

JOKES ACTIONS -> jokesAPI/jokes/...:

	/all -> show all jokes on database -> GET

	/update -> update a joke -> PUT
				need to put a joke structure as a JSON text changing the field that you want the update;
				Example: I want to change this joke's type
						{
					        "id": 7,
					        "type": "Game",
					        "joke": "Qual o game que só tem 1, 3, 5, 6, 7 e 9?\nAge of Impares",
					        "author": {
					            "id": 1,
					            "name": "www.pianoeletronico.com.br"
					        }
					    }

					    I have to PUT this JSON
						{
							"id": 7,
							"type": "NEW TYPE",
							"joke": "Qual o game que só tem 1, 3, 5, 6, 7 e 9?\nAge of Impares",
							"author":{
								"id": 1
							}
						}

	/create -> create a new joke -> POST
				need to put a joke structure as a JSON text;
				Example: I wanto to create this joke
						"Qual o game que só tem 1, 3, 5, 6, 7 e 9?\nAge of Impares"

						I have to POST this JSON
						{
							"id": 7,
							"type": "Game",
							"joke": "Qual o game que só tem 1, 3, 5, 6, 7 e 9?\nAge of Impares",
							"author":{
								"id": 1
							}
						}

	/delete -> delete a joke -> DELETE
				need to inform the id as a parameter;
				Exemple: I wanto to delete this joke
						{
					        "id": 7,
					        "type": "Game",
					        "joke": "Qual o game que só tem 1, 3, 5, 6, 7 e 9?\nAge of Impares",
					        "author": {
					            "id": 1,
					            "name": "www.pianoeletronico.com.br"
					        }
					    }

					    I have to DELETE using the id 7 like this
					    /jokesAPI/jokes/delete?id=7

AUTHORS ACTIONS -> jokesAPI/authors/...:

	/all -> show all authors on database -> GET

	/update -> update an author -> PUT
				need to put an author structure as a JSON text changing the field that you want the update;
				Example: I want to change this author's name
						{
					        "author": {
					            "id": 1,
					            "name": "www.pianoeletronico.com.br"
					        }
					    }

					    I have to PUT this JSON
						{
							"author": {
					            "id": 1,
					            "name": "NEW NAME"
					        }
						}

	/create -> create a new author -> POST
				need to put an author structure as a JSON text;
				Example: I wanto to create this author
						"www.pianoeletronico.com.br"

						I have to POST this JSON
						{
					        "author": {
					            "id": 1,
					            "name": "www.pianoeletronico.com.br"
					        }
					    }

	/delete -> delete an author -> DELETE
				need to inform the id as a parameter;
				Exemple: I wanto to delete this author
						{
					        "author": {
					            "id": 1,
					            "name": "www.pianoeletronico.com.br"
					        }
					    }

					    I have to DELETE using the id 1 like this
					    /jokesAPI/jokes/delete?id=1

					    WARNING: YOU CAN'T DELETE AN AUTHOR WHILE A JOKE DEPENDS ON IT!