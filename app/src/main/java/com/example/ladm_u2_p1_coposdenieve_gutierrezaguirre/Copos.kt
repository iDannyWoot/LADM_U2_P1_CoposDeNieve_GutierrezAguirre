package com.example.ladm_u2_p1_coposdenieve_gutierrezaguirre

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Copos (l:Lienzo) {
    var tam = 0f
    var movy = 0f
    var movx= 0f


    init {
        movx= (Math.random()*2400).toFloat()
        movy = ((Math.random()*-1800)).toFloat()
        tam = ((Math.random()*5)+5).toFloat()
    }

    fun pintar(canvas: Canvas){
        val p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(movx,movy,4f,p)
    }


    fun mover(){
        movy += ((Math.random() * 4) + 10).toFloat()

         if(movy >= 1000){

            movy = ((Math.random()*50)-50).toFloat()

         }
    }


}