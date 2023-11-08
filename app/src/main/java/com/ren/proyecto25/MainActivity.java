package com.ren.proyecto25;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btn5;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn5 = findViewById(R.id.button5);

    }

    public void destruir() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public void iniciar(View view) {
        destruir();
        mediaPlayer = MediaPlayer.create(this, R.raw.creep);
        mediaPlayer.start();
        String b5 = btn5.getText().toString();
        mediaPlayer.setLooping(!b5.equals("No reproducir en forma circular"));
    }

    public void pausar(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            posicion = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    public void continuar(View view) {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(posicion);
            mediaPlayer.start();
        }
    }

    public void detener(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            posicion = 0;
        }
    }

    public void circular(View view) {
        detener(null);
        String b5 = btn5.getText().toString();
        if (b5.equalsIgnoreCase("No reproducir en forma circular")) {
            btn5.setText("Reproducir en forma circular");
        } else {
            btn5.setText("No reproducir en forma circular");
        }
    }
}