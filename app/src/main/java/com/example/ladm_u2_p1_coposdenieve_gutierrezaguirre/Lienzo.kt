package com.example.ladm_u2_p1_coposdenieve_gutierrezaguirre

import android.view.View
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity): View(este) {
    val este = este
    val nieve = Array<Copos>(1500,{ Copos(this)})
    val intensidad: DoubleArray = doubleArrayOf(0.0,0.1,0.55,1.0)
    var selector = 0

    val coroutine = GlobalScope.launch {
        var tiempo = 0L
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            tiempo += 20

            if(tiempo == 8000L){
                selector++
                tiempo = 0
                if (selector == 4) selector = 0
            }
            delay(20L)


        }
    }

    override fun onDraw(c: Canvas) {
        val lim:Int = ((nieve.size-1)*intensidad[selector]).toInt()
        super.onDraw(c)
        c.drawColor(Color.BLUE)

        //LUNA
        val p = Paint()
        p.color = Color.WHITE
        c.drawCircle(200f,100f,80f,p)
        p.color = Color.BLUE
        c.drawCircle(240f,80f,40f,p)

        //Montaña izquierda
        p.color = Color.WHITE;
        c.drawOval(-100f,600f,1600f,1300f,p);
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4.0f
        p.color = Color.CYAN
        c.drawOval(-100f,600f,1600f,1300f,p);

        //Montaña derecha
        p.color = Color.WHITE;
        p.style = Paint.Style.FILL
        c.drawOval(900f,500f,2500f,1300f,p);
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4.0f
        p.color = Color.CYAN
        c.drawOval(900f,500f,2500f,1300f,p);

        //arbol
        p.color = Color.rgb(180,114,20);
        p.style = Paint.Style.FILL
        c.drawRect(500f,700f,550f,800f,p);
        p.color = Color.GREEN
        c.drawOval(450f,630f,600f,720f,p)
        c.drawOval(450f,560f,600f,650f,p)

        //arbol2
        p.color = Color.rgb(180,114,20);
        c.drawRect(1300f,600f,1400f,750f,p);
        p.color = Color.GREEN
        c.drawOval(1200f,480f,1500f,650f,p)
        c.drawOval(1200f,380f,1500f,570f,p)

        //casa
        p.color = Color.rgb(180,114,20)
        c.drawRect(1650f,400f,1950f,550f,p)
        p.color = Color.YELLOW
        c.drawRect(1700f,470f,1750f,550f,p)
        p.color = Color.RED
        var path = Path()
        path.moveTo(1700f,350f)
        path.lineTo(1900f,350f)
        path.lineTo(2000f,430f)
        path.lineTo(1600f,430f)
        path.lineTo(1700f,350f)
        c.drawPath(path,p)




        (0..lim).forEach {
            nieve[it].mover()
            nieve[it].pintar(c)
        }

        }


}