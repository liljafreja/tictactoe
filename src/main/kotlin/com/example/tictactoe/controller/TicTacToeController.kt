package com.example.tictactoe.controller

import com.example.tictactoe.persistance.GameRepository
import com.example.tictactoe.persistance.TicTacToeGame
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/game/tictactoe")
class TicTacToeController(private val repository: GameRepository) {
    @PostMapping
    fun createGame(): UUID? {
        val newGame = TicTacToeGame()
        return repository.save(newGame).id
    }
}
