package com.example.tictactoe.persistence

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface GameRepository : CrudRepository<TicTacToeGame, UUID>