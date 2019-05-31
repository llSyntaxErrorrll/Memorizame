package com.apps.memorizame;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.SQLite.SubCategoriasCRUD;
import com.apps.memorizame.Tools.Constans;
import com.ortiz.touchview.TouchImageView;
import java.util.concurrent.TimeUnit;

public class InicioFrgImagen extends Fragment {

    //decraracion de variables
    private ClickImagen clickImagen;
    private View view;
    private TouchImageView imagen;
    private Button btnTermina;
    private long timeCountInMilliSeconds = 1 * 60000;
    private ProgressBar progressBarCircle;
    private TextView textViewTime;
    private CountDownTimer countDownTimer;
    private int idSubCategoria=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //obtener id de la subcategoria
        if (getArguments() != null) {
            idSubCategoria = getArguments().getInt(Constans.dbColumSubCatego_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.inicio_frg_imagen, container, false);

        referenciar();

        //consulta la subcategoria por id
        SubCategoriasCRUD crud = new SubCategoriasCRUD(view.getContext());
        SubCategoriasEntity entity = new SubCategoriasEntity(null,null,0,0,0);
        entity.setIdSubCategoria(idSubCategoria);

        //datos
        Cursor rs = crud.readById(entity);
        rs.moveToFirst();

        //establecer imagen
        @DrawableRes
        int res = getResources().getIdentifier(rs.getString(Constans.dbColumSubCatego_imag_index), "drawable", view.getContext().getPackageName());
        imagen.setImageResource(res);

        iniciarTemporizador();

        return view;
    }

    private void referenciar() {
        imagen = (TouchImageView) view.findViewById(R.id.imgTouchUno);
        progressBarCircle = (ProgressBar) view.findViewById(R.id.progressBarCircle);
        textViewTime = (TextView) view.findViewById(R.id.textViewTime);
        btnTermina = (Button) view.findViewById(R.id.btnTerminar);
        btnTermina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Método que detiene el temporizador
                countDownTimer.cancel();

                //llama al calback
                clickImagen.ClickImagen();
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

                //Método que detiene el temporizador
                countDownTimer.cancel();

                //llama al calback
                clickImagen.ClickImagen();
            }

        }.start();
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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickImagen = (ClickImagen) context;
    }

    public interface ClickImagen{
        void ClickImagen();
    }
}
