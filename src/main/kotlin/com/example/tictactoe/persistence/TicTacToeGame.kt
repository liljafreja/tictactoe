package com.example.tictactoe.persistence

import jakarta.persistence.*
import java.util.*

@Entity
class TicTacToeGame(
    @Id @GeneratedValue var id: UUID? = null,
    var firstTurnPlayerX: Boolean = true,
    @OneToMany(cascade = [CascadeType.ALL]) var turns: MutableList<Turn> = mutableListOf()
)

@Entity
class Turn(
    @Id @GeneratedValue var id: Int? = null,
    var playerX: Boolean = true,
    var xPosition: Int = 0,
    var yPosition: Int = 0
)