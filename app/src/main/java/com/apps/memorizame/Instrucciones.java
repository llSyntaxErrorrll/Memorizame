package com.apps.memorizame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.apps.memorizame.ui.main.SectionsPagerAdapter;
import com.apps.memorizame.ui.main.Tercer_fragment;

public class Instrucciones extends AppCompatActivity implements Tercer_fragment.CLickFinalizar {

    //variables
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        Pasar();
    }

    private void Pasar() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //carga el 2do tab despues de 5s
                    Thread.sleep(5000);
                    if(tabs.getTabAt(0).isSelected()){
                        tabs.getTabAt(1).select();
                    }

                    //carga el ultimo tab despues de 5s
                    Thread.sleep(5000);
                    if(tabs.getTabAt(1).isSelected()){
                        tabs.getTabAt(2).select();
                    }

                }catch (Exception e){
                    Toast.makeText(Instrucciones.this, "", Toast.LENGTH_SHORT).show();
                }

            }
        }).start();

    }


    @Override
    public void cLickFinalizar() {
        finish();
    }
}