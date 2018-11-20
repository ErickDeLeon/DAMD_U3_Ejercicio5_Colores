package mx.edu.ittepic.damd_u3_ejercicio5_colores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    Imagen img1, img2, img3, puntero;
    String mensaje;
    MainActivity puntero2;

public Lienzo (Context context){
    super(context);

    mensaje = "WELCOME TO COLOR PLAY";

    img1 = new Imagen(R.drawable.inicio, 1000,1400,this);
    img2 = new Imagen(R.drawable.jugar,1000,1750,this);
    img3 = new Imagen(R.drawable.happy,50,500,this);

    puntero2 = (MainActivity) context;

    puntero = null;

}

protected void onDraw(Canvas c){
    super.onDraw(c);
    Paint p = new Paint();

    p.setTextSize(100);
    p.setColor(Color.MAGENTA);
    c.drawText(mensaje,50,200,p);

    img1.pintar(c,p);
    img2.pintar(c,p);
    img3.pintar(c,p);
}

public boolean onTouchEvent(MotionEvent e){

    float xp = e.getX();
    float yp = e.getY();

    switch (e.getAction()){
        case MotionEvent.ACTION_DOWN:
            if (img1.estaEnArea(xp,yp)){
                mensaje =  "Star";
                puntero = img1;
                otraPantalla();
            }
            if (img2.estaEnArea(xp,yp)){
                mensaje = "Play";
                puntero = img2;
                otraPantallaDos();
            }
            break;

        case MotionEvent.ACTION_MOVE:
            break;

        case MotionEvent.ACTION_UP:
            puntero = null;
            break;
    }

    invalidate();
    return true;

}

    public void otraPantalla (){
    Intent pantalla2 = new Intent (puntero2, Main2Activity.class);
    puntero2.startActivity(pantalla2);
}

    public void otraPantallaDos (){
        Intent pantalla2 = new Intent (puntero2, Main3Activity.class);
        puntero2.startActivity(pantalla2);
    }
}
