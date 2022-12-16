package com.psrc.common

import androidx.compose.runtime.*
import com.psrc.common.domain.model.MoveTypes
import com.psrc.common.domain.model.TicTacToe
import com.psrc.common.presentation.ui.components.TicTacToeView

@Composable
fun App() {
    val ticTacToe by remember { mutableStateOf(TicTacToe()) }
    var houses by remember { mutableStateOf(ticTacToe.getHouses()) }

    TicTacToeView(
        houses,
        onHouseClicked = {
            houses = ticTacToe.apply {
                addMove(it, MoveTypes.values().random())
            }.getHouses()
        }
    )
}
