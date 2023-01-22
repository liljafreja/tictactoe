package com.example.tictactoe.domain

import com.example.tictactoe.persistence.TicTacToeGame
import org.springframework.stereotype.Component

@Component
class TicTacToeConverter {
    fun createTicTacToeEntity(game: TicTacToeGame): TicTacToeEntity {
        val dimension = 3
        val gameBoard = Array(dimension) { CharArray(dimension) { ' ' } }
        var nextTurn = if (game.firstTurnPlayerX) 'x' else 'o' // In case the game just got initialized
        for (turn in game.turns) {
            if (turn.playerX) {
                gameBoard[turn.yPosition][turn.xPosition] = 'x'
                nextTurn = 'o'
            } else {
                gameBoard[turn.yPosition][turn.xPosition] = 'o'
                nextTurn = 'x'
            }
        }
        // TODO: implement checking for winner logic
        return TicTacToeEntity(gameBoard.map { it.asList() }, nextTurn, null)
    }
}