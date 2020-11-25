package com.elnaggar.compose.animations

import android.util.Log
import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun StateCircle(modifier: Modifier = Modifier, stateNum: Int = 5) {
    val animateProgress = animatedFloat(initVal = 0f)

    onActive {
        animateProgress.animateTo(
            01f,
            anim = repeatable(
                iterations = AnimationConstants.Infinite,
                animation = tween(durationMillis = 3000, easing = LinearEasing)
            )
        )

    }
    val t = animateProgress.value
    val sweepAngle = t  * 360f
    val partSweepAngle = 360f / stateNum
    Canvas(modifier = modifier) {
        if (t >= 0.5f) {
            var parts = (sweepAngle / partSweepAngle).toInt()
            val remains = sweepAngle % partSweepAngle
            if (remains != 0f) {
                parts += 1
            }
            for (i in 0 until parts) {
                if (i == parts - 1) {
                    if (remains == 0f) {
                        drawPart(i + 1, partSweepAngle)
                    } else {
                        drawPart(i + 1, remains)
                    }
                } else {
                    drawPart(i + 1, partSweepAngle)
                }


            }
            drawCircles(stateNum,1f)
        }else{
            drawCircles(stateNum, t*2)
        }

    }
}

fun DrawScope.drawCircles(num: Int, t: Float) {
    val r = (size.width / 2)*t
    val partSweepAngle = 260 / num
    val centerX = size.width / 2
    val centerY = size.width / 2
    val startAngle = (Math.PI / 3)
    val padding = 58.dp.toPx()
    for (i in 0 until num) {
        var theta: Double = if (i == 0) {
            startAngle
        } else {
            (startAngle + (i * ((2 * Math.PI) / num)))
        }

        val newX = centerX + cos(theta) * (r)
        val newY = centerY + sin(theta) * (r)
        val x = (r * sin(theta))
        val y = (r * cos(theta))

            val color = Color(
                    red = -(1f*t)+1f,
                    blue = -(1f*t)+1f,
                    green = -(1f*t)+1f
            )
            drawCircle(
                color = color,
                radius =  80.dp.value,
                center = Offset(newX.toFloat(), newY.toFloat())
            )
//            drawArc(
//                    color = Color.Black,
//                    startAngle = 30f,
//                    sweepAngle = 300f,
//                    useCenter = true,
//                    size = Size(200f, 200f),
//                    topLeft = Offset(newX.toFloat() - 100f, newY.toFloat() - 100f)
//            )
            Log.d("xxxxxcordainte", "angle = $theta r =$r  x =$x y =$y padding = $padding  color=${color.toString()}")
            theta += partSweepAngle


    }
}

fun DrawScope.drawPart(part: Int, sweepAngle: Float) {
    val oval = Rect(0f, 0f, size.width, size.width)
    val path = Path()
    path.arcTo(oval, getStartAngelByPart(part, sweepAngle = sweepAngle).toFloat(), sweepAngle, true)
    drawPath(
        path = path,
        brush = SolidColor(value = if (part % 2 == 0) Color.Red else Color.Cyan),
        style = Stroke(width = 8f)
    )
}



