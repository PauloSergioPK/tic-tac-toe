package com.psrc.common.presentation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.psrc.common.domain.model.MoveTypes
import com.psrc.common.presentation.ui.resources.getCircleIconResource
import com.psrc.common.presentation.ui.resources.getCrossIconResource

@Composable
fun TicTacToeView(
    houses: List<MoveTypes?>,
    onHouseClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        modifier = modifier.background(Color.Black)
    ) {
        houses.forEachIndexed { index, it ->
            item { House(it, onHouseClicked, index) }
        }
    }
}

@Composable
private fun House(
    moveType: MoveTypes?,
    onHouseClicked: (Int) -> Unit,
    index: Int
) {

    Box(Modifier.size(200.dp).background(Color.White).clickable { onHouseClicked.invoke(index) }) {
        val moveTypeResource = moveType?.let {
            when (it) {
                MoveTypes.CROSS -> getCrossIconResource()
                MoveTypes.CIRCLE -> getCircleIconResource()
            }
        }

        AnimatedVisibility(moveType != null) {
            moveTypeResource?.let {
                Icon(it, contentDescription = null, tint = Color.Black)
            }
        }
    }
}

