package mx.edu.ittepic.damd_u3_ejercicio5_colores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class LienzoDos extends View {

    ImagenDos imgnegro, imgazul, imgverde, imgnaranja, imgamarillo, imggris, puntero, regrsar;
    String mensaje;
    MediaPlayer player;
    Main2Activity puntero2;


    public LienzoDos (Context context){
        super(context);

        mensaje = "Toca el color y escucha";

        imgnegro = new ImagenDos(R.drawable.negro, 20, 200, this);
        imgamarillo = new ImagenDos(R.drawable.amarillo, 560, 200, this);
        imgazul = new ImagenDos(R.drawable.azul,1210 , 200, this);

        imgnaranja = new ImagenDos(R.drawable.naranja, 20, 1000, this);
        imgverde = new ImagenDos(R.drawable.verde, 615, 1000, this);
        imggris = new ImagenDos(R.drawable.gris,1210 , 1000, this);

        regrsar = new ImagenDos(R.drawable.regresar, 700, 2000, this);

        puntero2 = (Main2Activity) context;

        puntero = null;

    }

    protected void onDraw(Canvas c){
        super.onDraw(c);

        Paint p = new Paint();

        p.setTextSize(50);
        p.setColor(Color.RED);
        c.drawText(mensaje,50,100,p);
        imgnegro.pintar(c,p);
        imgamarillo.pintar(c,p);
        imgazul.pintar(c,p);
        imgnaranja.pintar(c,p);
        imgverde.pintar(c,p);
        imggris.pintar(c,p);

        regrsar.pintar(c,p);

    }

    public  boolean onTouchEvent (MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:

                if (imgnegro.estaEnArea(xp,yp)){
                    mensaje = "Negro";
                    puntero = imgnegro;

                        player = MediaPlayer.create(puntero2, R.raw.au_black);
                        player.start();
                }
                if (imgamarillo.estaEnArea(xp,yp)){
                    mensaje = "Amarillo";
                    puntero = imgamarillo;

                    player = MediaPlayer.create(puntero2, R.raw.au_yellow);
                    player.start();

                }
                if (imgazul.estaEnArea(xp,yp)){
                    mensaje = "Azul";
                    puntero = imgazul;

                    player = MediaPlayer.create(puntero2, R.raw.au_blue);
                    player.start();

                }
                if (imgnaranja.estaEnArea(xp,yp)){
                    mensaje = "Naranja";
                    puntero = imgnaranja;

                    player = MediaPlayer.create(puntero2, R.raw.au_orange);
                    player.start();

                }
                if (imgverde.estaEnArea(xp,yp)){
                    mensaje = "Verde";
                    puntero = imgverde;

                    player = MediaPlayer.create(puntero2, R.raw.au_green);
                    player.start();

                }
                if (imggris.estaEnArea(xp,yp)){
                    mensaje = "Gris";
                    puntero = imggris;

                    player = MediaPlayer.create(puntero2, R.raw.au_gray);
                    player.start();

                }
                if(regrsar.estaEnArea(xp,yp)){
                    puntero = regrsar;
                    regresarHome();
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

    private void regresarHome() {

        Intent pantallaUno = new Intent(puntero2, MainActivity.class);
        puntero2.startActivity(pantallaUno);

    }
}
