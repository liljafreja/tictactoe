package com.example.tictactoe.persistance

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface GameRepository: CrudRepository<TicTacToeGame, UUID>