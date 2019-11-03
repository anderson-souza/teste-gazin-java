curl --header "Content-Type: application/json" --request POST --data @ator.json http://localhost:8080/api/ator

curl --header "Content-Type: application/json" --request POST --data @produtor.json http://localhost:8080/api/produtor

curl --header "Content-Type: application/json" --request POST --data @diretor.json http://localhost:8080/api/diretor

curl --header "Content-Type: application/json" --request POST --data @filme.json http://localhost:8080/api/filme

curl http://localhost:8080/api/filme

cmd /k