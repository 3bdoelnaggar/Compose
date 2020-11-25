package com.elnaggar.compose.animations

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun Tanora(modifier: Modifier = Modifier) {
    val animateProgress = animatedFloat(initVal = 0f)

    onActive {
        animateProgress.animateTo(
            1f,
            anim = repeatable(
                iterations =3,
                animation = tween(durationMillis = 3000, easing = LinearEasing)
            )
        )
    }


    val t = animateProgress.value
    val sweepAngle = t * 360f
    val partSweepAngle = 360f / 20f
    Canvas(modifier = modifier) {
        var parts = (sweepAngle / partSweepAngle).toInt()
        val remains = sweepAngle % partSweepAngle
        if (remains != 0f) {
            parts += 1
        }
        for (i in 0 until parts) {
            if (i == parts - 1) {
                if (remains == 0f) {
                    drawTanoraPart(i + 1, partSweepAngle)
                } else {
                    drawTanoraPart(i + 1, remains)
                }
            } else {
                drawTanoraPart(i + 1, partSweepAngle)
            }


        }



    }
}

fun DrawScope.drawTanoraPart(part: Int, sweepAngle: Float) {

    for(x in 0..20){
        val inset=x*10
        val oval = Rect(0f+inset, 0f+inset, size.width-inset, size.width-inset)
        val path = Path()
        path.arcTo(oval, getStartAngelByPart(part, sweepAngle = sweepAngle).toFloat(), sweepAngle, true)
        drawPath(
            path = path,
            brush = SolidColor(value = if (part % 2 == 0) Color.Red else Color.Cyan),
            style = Stroke(width = 8f)
        )
    }

}


