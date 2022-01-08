package com.madsys.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyCanvas @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paintText = Paint().apply {
        color = Color.YELLOW
        textAlign = Paint.Align.CENTER
        textSize = 40f
    }
    private val paintGreen = Paint().apply {
        color = Color.GREEN
    }
    private val paintRed = Paint().apply {
        color = Color.RED
        setShadowLayer(10f, 10f, 10f, Color.BLACK)
    }
    private val paintTransparent = Paint().apply {
        color = Color.TRANSPARENT
        setShadowLayer(10f, 10f, 10f, Color.BLACK)
    }
    private val rectBg = Rect(0, 0, 800, 200)
    private val rectRed = Rect(200, 0, 400, 200)
    private val rectTransparent = RectF(400f, 0f, 600f, 200f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)
        canvas?.drawRect(rectBg, paintGreen)
        canvas?.drawRect(rectRed, paintRed)
        canvas?.drawRect(rectTransparent, paintTransparent)

        canvas?.drawText(
            "RED",
            rectRed.centerX().toFloat(),
            rectRed.centerY().toFloat(),
            paintText
        )
        canvas?.drawText(
            "TRANS",
            rectTransparent.centerX().toFloat(),
            rectTransparent.centerY().toFloat(),
            paintText
        )
    }
}