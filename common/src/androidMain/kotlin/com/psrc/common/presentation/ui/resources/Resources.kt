package com.psrc.common.presentation.ui.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.psrc.common.R
@Composable

actual fun getCrossIconResource(): Painter {
    return painterResource(R.drawable.ic_cross)
}
@Composable

actual fun getCircleIconResource(): Painter {
    return painterResource(R.drawable.ic_circle)
}