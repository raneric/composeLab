package com.sgg.composelab.animationAndDraw

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgg.composelab.ui.theme.ComposeLabTheme

@Composable
fun DrawAnimation(modifier: Modifier = Modifier) {
    val lineWeight = with(LocalDensity.current) { 1.dp.toPx() }
    val verticalRegion = 5
    val horizontalRegion = 5
    val strokeColor = Color(0xFF0288D1)

    Box(modifier = modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Canvas(modifier = Modifier
            .padding(8.dp)
            .aspectRatio(3 / 2f)
            .fillMaxSize()) {

            drawRect(color = strokeColor,
                     style = Stroke(lineWeight))

            var offsetX = size.width / verticalRegion
            repeat(verticalRegion) {
                drawLine(
                        color = strokeColor,
                        start = Offset(offsetX, 0f),
                        end = Offset(offsetX, size.height),
                )
                offsetX += size.width / verticalRegion
            }

            var offsetY = size.height / horizontalRegion
            repeat(horizontalRegion) {
                drawLine(
                        color = strokeColor,
                        start = Offset(0f, offsetY),
                        end = Offset(size.width, offsetY),
                )
                offsetY += size.height / horizontalRegion
            }

            val path = generatePath(fakeDataList, size)
            val backgroundPath = Path().apply {
                addPath(path)
                relativeLineTo(0f, size.height)
                lineTo(0f, size.height)
                close()
            }

            drawPath(path = path,
                     color = strokeColor,
                     style = Stroke(lineWeight))

            drawPath(path = backgroundPath,
                     brush = Brush.verticalGradient(
                             colors = listOf(
                                     Color(0xFF9B68F7).copy(alpha = 0.4f),
                                     Color.Transparent),
                             startY = 0f,
                             endY = size.height
                     ),
                     style = Fill
            )
        }
    }
}

@Preview
@Composable
private fun DrawAnimationPrev() {
    ComposeLabTheme {
        DrawAnimation()
    }
}


private fun generatePath(
        data: List<Sales>,
        size: Size
): Path {
    val path = Path()
    val dataList = scaledData(data, size)
    val horizontalDivision = size.width / dataList.size
    var startX = 0f

    path.moveTo(startX, size.height)
    dataList.forEach {
        startX += horizontalDivision
        path.lineTo(startX, size.height - it.amount)
    }
    return path
}

private fun scaledData(
        data: List<Sales>,
        size: Size
): List<Sales> {
    val maxAmount = data.maxOf { it.amount }
    return data
        .sortedBy { it.year }
        .map { it.copy(amount = (it.amount * (size.height - (size.height / 10))) / maxAmount) }
}
