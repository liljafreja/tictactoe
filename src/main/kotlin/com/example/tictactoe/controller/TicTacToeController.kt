package com.example.tictactoe.controller

import com.example.tictactoe.domain.TicTacToeConverter
import com.example.tictactoe.domain.TicTacToeEntity
import com.example.tictactoe.persistence.GameRepository
import com.example.tictactoe.persistence.TicTacToeGame
import com.example.tictactoe.persistence.Turn
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.random.Random.Default.nextBoolean

@RestController
@RequestMapping("/game/tictactoe")
class TicTacToeController(private val repository: GameRepository, private val converter: TicTacToeConverter) {
    @PostMapping
    fun createGame(): TicTacToeGame {
        val firstTurnPlayerX = nextBoolean()
        val newGame = TicTacToeGame(firstTurnPlayerX = firstTurnPlayerX)
        return repository.save(newGame)
    }

    @PostMapping("/{gameId}/turns")
    fun createTurn(
        @PathVariable gameId: UUID,
        @RequestParam(name = "playerx") playerX: Boolean,
        @RequestParam(name = "xposition") xPosition: Int,
        @RequestParam(name = "yposition") yPosition: Int
    ): TicTacToeEntity {
        // TODO: gracefully handle not found game with 404 code
        val existingGame: TicTacToeGame = repository.findById(gameId).get()
        val turn: Turn = Turn(
            playerX = playerX,
            xPosition = xPosition,
            yPosition = yPosition
        )
        existingGame.turns.add(turn)
        val savedGame = repository.save(existingGame)
        return converter.createTicTacToeEntity(savedGame)
    }
}
