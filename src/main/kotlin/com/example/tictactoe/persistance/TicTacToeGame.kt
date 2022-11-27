package com.example.tictactoe.persistance

import jakarta.persistence.*
import lombok.EqualsAndHashCode
import lombok.ToString
import java.util.*

@Entity
class TicTacToeGame(
    @Id @GeneratedValue var id: UUID? = null,
    @OneToMany(cascade = [CascadeType.ALL]) var turns: MutableList<Turn> = mutableListOf()
)

@Entity
class Turn(
    @Id @GeneratedValue var id: Int? = null,
    var playerX: Boolean = true,
    var xPosition: Int = 0,
    var yPosition: Int = 0
)