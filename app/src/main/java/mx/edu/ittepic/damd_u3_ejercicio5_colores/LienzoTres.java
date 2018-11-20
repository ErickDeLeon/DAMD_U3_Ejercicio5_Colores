package mx.edu.ittepic.damd_u3_ejercicio5_colores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoTres extends View {

    ImagenTres colornaranja, colorverde, colorazul, nombrenaranja, nombreverde, nombreazul, puntero, regresar;
    String mensaje;
    Main3Activity punero2;

    public LienzoTres (Context context){
        super(context);

        mensaje = "Arrastra el texto al color que corresponde";

        colornaranja = new ImagenTres(R.drawable.cuadro_naranja, 100, 250, this);
        nombreverde = new ImagenTres(R.drawable.letra_verde, 1050, 250, this);

        colorazul = new ImagenTres(R.drawable.cuadro_azul, 100, 850, this);
        nombrenaranja = new ImagenTres(R.drawable.letra_naranja, 1050, 850,this);

        colorverde = new ImagenTres(R.drawable.cuadro_verde, 100, 1450,this);
        nombreazul = new ImagenTres(R.drawable.letra_azul, 1050, 1450, this);

        regresar = new ImagenTres(R.drawable.regresar, 700, 2050, this);



    }

    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(100);
        p.setColor(Color.MAGENTA);
        c.drawText(mensaje, 50, 100,p);

        colornaranja.pintar(c,p);
        colorazul.pintar(c,p);
        colorverde.pintar(c,p);

        nombreverde.pintar(c,p);
        nombrenaranja.pintar(c,p);
        nombreazul.pintar(c,p);

        regresar.pintar(c,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX();
        float yp = e.getY();


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (nombreverde.estaEnArea(xp, yp)){
                    mensaje = "VERDE";
                    puntero = nombreverde;
                }
                if (nombrenaranja.estaEnArea(xp, yp)){
                    mensaje = "NARANJA";
                    puntero = nombrenaranja;
                }
                if (nombreazul.estaEnArea(xp, yp)){
                    mensaje = "AZUL";
                    puntero = nombreazul;
                }
                if(regresar.estaEnArea(xp,yp)){
                    puntero = regresar;
                    regresarHome();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    puntero.mover(xp, yp);
                    if(puntero.colision(colornaranja) && puntero == nombrenaranja){
                        mensaje ="Correcto, NARANJA";
                        colornaranja.hacerVisible(false);
                        nombrenaranja.hacerVisible(false);
                    }
                    if(puntero.colision(colorazul) && puntero == nombreazul){
                        mensaje ="Correcto, AZUL";
                        colorazul.hacerVisible(false);
                        nombreazul.hacerVisible(false);
                    }
                    if(puntero.colision(colorverde) && puntero == nombreverde){
                        mensaje ="Correcto, VERDE";
                        colorverde.hacerVisible(false);
                        nombreverde.hacerVisible(false);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }
        invalidate();
        return true;

    }

    private void regresarHome() {

        Intent pantallaInicio = new Intent(punero2,MainActivity.class);
        punero2.startActivity(pantallaInicio);

    }

}
