package com.elnaggar.compose.animations

// return where that part start
fun getStartAngelByPart(part: Int, sweepAngle: Float): Int {
    var returnedValue = 198 + part * sweepAngle.toInt()
    if (returnedValue > 360) {
        returnedValue %= 360
    }
    return returnedValue
}