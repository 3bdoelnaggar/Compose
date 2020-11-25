package com.elnaggar.compose.animations.shaps

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.elnaggar.compose.animations.getStartAngelByPart

@Preview(showBackground = true)
@Composable
fun previewTanora() {
    MaterialTheme() {
        TanoraAnimation(modifier = Modifier.fillMaxSize().padding(80.dp), unActiveColor = Color.Black, activeColor = Color.Magenta)
    }
}

@Composable
fun TanoraAnimation(modifier: Modifier = Modifier, repeat: Int = Int.MAX_VALUE, activeColor: Color = Color.Red, unActiveColor: Color = Color.Cyan) {
    val animateProgress = animatedFloat(initVal = 0f)

    onActive {
        animateProgress.animateTo(
                1f,
                anim = repeatable(
                        iterations = repeat,
                        animation = tween(durationMillis = 3000, easing = LinearEasing)
                )
        )
    }


    val t = animateProgress.value
    val sweepAngle = t * 2 * 360f
    val partSweepAngle = 360f / 30f
    Canvas(modifier = modifier) {
        var parts = (sweepAngle / partSweepAngle).toInt()
        val remains = sweepAngle % partSweepAngle
//        //with flicker
//        for (i in 0 until parts) {
//            if (i == parts - 1) {
//                if (remains == 0f) {
//                    drawRacePart(i + 1, partSweepAngle, activeColor, unActiveColor)
//                } else {
//                    drawRacePart(i + 1, remains, activeColor, unActiveColor)
//                }
//            } else {
//                drawRacePart(i + 1, partSweepAngle, activeColor, unActiveColor)
//            }
//
//
//        }


        if (t < .5f) {

            //without flicker
            for (i in 0 until parts) {
                drawRacePart(i + 1, partSweepAngle, activeColor, unActiveColor)
            }
            val reverseParts = 32 - parts
            for (x in 0 until reverseParts) {
                drawReversePart(x + 1, partSweepAngle, activeColor, unActiveColor)
            }
        } else {
            for (i in 0 until parts) {
                drawReversePart(i + 1, partSweepAngle, activeColor, unActiveColor)
            }
            val reverseParts = 32 - parts
            for (x in 0 until reverseParts) {
                drawRacePart(x + 1, partSweepAngle, activeColor, unActiveColor)
            }
        }


    }


}

fun DrawScope.drawRacePart(part: Int, sweepAngle: Float, activeColor: Color, unActiveColor: Color) {
    val size = this.size
    for (x in 0..20) {
        val inset = x * 10
        val cut = x * 2
        val oval = Rect(0f + inset, 0f + inset, size.width - inset, size.width - inset)
        val path = Path()
        path.arcTo(oval, getStartAngelByPart(part, sweepAngle = sweepAngle).toFloat(), sweepAngle, true)
        drawPath(
                path = path,
                brush = SolidColor(value = if (part % 2 == 0) activeColor else unActiveColor),
                style = Stroke(width = 8f)
        )
    }


}

fun DrawScope.drawReversePart(part: Int, sweepAngle: Float, activeColor: Color, unActiveColor: Color) {
    for (x in 20..40) {
        val inset = x * 10
        val cut = x * 2
        val reverseSweepAngle = sweepAngle
        val reversePart = part
        val oval = Rect(0f + inset, 0f + inset, size.width - inset, size.width - inset)
        val path = Path()
        path.arcTo(oval, getStartAngelByPart(reversePart, sweepAngle = reverseSweepAngle).toFloat(), reverseSweepAngle, true)
        drawPath(
                path = path,
                brush = SolidColor(value = if (part % 2 == 0) activeColor else unActiveColor),
                style = Stroke(width = 8f)
        )
    }
}


