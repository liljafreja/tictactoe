GAME_ID=$(curl -X POST http://localhost:8080/game/tictactoe | jq -r '.id')
curl -X POST -F 'playerx=true' -F 'xposition=0' -F 'yposition=0' "http://localhost:8080/game/tictactoe/$GAME_ID/turns"
curl -X POST -F 'playerx=false' -F 'xposition=1' -F 'yposition=0' "http://localhost:8080/game/tictactoe/$GAME_ID/turns"