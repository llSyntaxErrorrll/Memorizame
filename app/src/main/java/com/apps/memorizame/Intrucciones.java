package com.apps.memorizame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.apps.memorizame.Adapters.ViewPagerAdapter;

public class Intrucciones extends AppCompatActivity {

    private TabLayout tabLayout;
    private  int [] tabIcon = {R.drawable.ic_vector_book,R.drawable.ic_vector_lock};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrucciones);
        ViewPager viewPager = findViewById(R.id.VPIntrucciones);
        LoadViewPager(viewPager);
        tabLayout = findViewById(R.id.TLInstrucciones);
        tabLayout.setupWithViewPager(viewPager);
        TabIcons();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            iconColor(tab, "fffddd");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                iconColor(tab, "f2fd2d");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void iconColor(TabLayout.Tab tab,String color ){
        tab.getIcon().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
    }

    private void LoadViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.Addfragment(newInstance("Home"));
        adapter.Addfragment(newInstance("Friends"));
        adapter.Addfragment(newInstance("Notificaciones"));
        adapter.Addfragment(newInstance("Salir"));

        viewPager.setAdapter(adapter);
    }
    private OneFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        OneFragment fragment = new OneFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
    private void TabIcons () {
        for(int i=0; i<4;i++){
            tabLayout.getTabAt(i).setIcon(tabIcon[i]);
        }
    }
}
