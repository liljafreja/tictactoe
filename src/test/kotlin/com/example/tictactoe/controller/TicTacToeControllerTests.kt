package com.example.tictactoe.controller

import com.example.tictactoe.persistance.GameRepository
import com.example.tictactoe.persistance.TicTacToeGame
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@WebMvcTest
class TicTacToeControllerTests {
    @MockkBean
    private lateinit var repository: GameRepository

    @Autowired
    private lateinit var gameController: TicTacToeController

    @Test
    fun `should create a new game`() {
        every { repository.save(any()) } returns TicTacToeGame(
            UUID.fromString("d9a0291e-464e-44be-b1c1-45603688fa87")
        )
        assertThat(gameController.createGame().id).isEqualTo(
            UUID.fromString("d9a0291e-464e-44be-b1c1-45603688fa87")
        )
    }
}