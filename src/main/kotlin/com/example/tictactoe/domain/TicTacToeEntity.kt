package com.example.tictactoe.domain

data class TicTacToeEntity(val board: List<List<Char>>, val nextTurn: Char?, val winner: Char?)