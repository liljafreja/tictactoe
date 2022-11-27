package com.example.tictactoe.persistance

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.*

@Entity
class TicTacToeGame(
    @Id @GeneratedValue var id: UUID? = null,
    @OneToMany var turns: MutableList<Turn> = mutableListOf<Turn>()
)

@Entity
class Turn(
    @Id @GeneratedValue var id: Int = 1,
    var playerX: Boolean = true,
    var xPosition: Int = 0,
    var yPosition: Int = 0
)