package com.apps.memorizame;

import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.SQLite.SubCategoriasCRUD;
import com.apps.memorizame.Tools.Constans;
import com.ortiz.touchview.TouchImageView;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

public class MemorizaImagen extends AppCompatActivity {

    private TouchImageView imagen;
    private Button btnTermina;
    private long timeCountInMilliSeconds = 1 * 60000;
    private ProgressBar progressBarCircle;
    private TextView textViewTime;
    private CountDownTimer countDownTimer;
    private int idSubCategoria=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoriza_imagen);

        //obtiene el id ed la subcategoria
        idSubCategoria = getIntent().getExtras().getInt(Constans.dbColumSubCatego_id);

        referenciar();

        //consulta la subcategoria por id
        SubCategoriasCRUD crud = new SubCategoriasCRUD(getApplicationContext());
        SubCategoriasEntity entity = new SubCategoriasEntity(null,null,0,0,null);
        entity.setIdSubCategoria(idSubCategoria);

        //datos
        Cursor rs = crud.readById(entity);
        rs.moveToFirst();

        //establecer imagen
        @DrawableRes
        int res = getResources().getIdentifier(rs.getString(Constans.dbColumSubCatego_imag_index), "drawable", getPackageName());
        Picasso.with(this).load(res).into(imagen);

        iniciarTemporizador();
    }

    private void referenciar() {
        imagen = (TouchImageView) findViewById(R.id.imgTouchUno);
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        btnTermina = (Button) findViewById(R.id.btnTerminar);
        btnTermina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pr = new Intent(MemorizaImagen.this, Preguntas.class);
                pr.putExtra("id", idSubCategoria);
                startActivity(pr);
                stopCountDownTimer();
                finish();
            }
        });
    }
    //Método que inicia el el temporizador
    private void iniciarTemporizador() {

        // llamado del método que le setea el valor al temporizador
        setTimerValues();
        // llamado al método que le setea los valores a la barra de progreso
        setProgressBarValues();
        // llamado al método del temporizador
        startCountDownTimer();
    }

   //Setea el vlaor a la variable timeCountInMilliSeconds para que sea de 2 min
    private void setTimerValues() {
        int time = 2;
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = time * 60 * 1000;
    }

    //Método del Temporizador
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                Intent pr = new Intent(MemorizaImagen.this,Preguntas.class);
                pr.putExtra("id", idSubCategoria);
                startActivity(pr);
                stopCountDownTimer();
                finish();
            }

        }.start();
        countDownTimer.start();
    }

    //Método que detiene el temporizador
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    //Método que setea los valores a la barra de progreso
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }


    //método para el formato de tiempo
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;
    }
}
