package com.apps.memorizame.ui.main;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.apps.memorizame.R;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class Primer_fragment extends Fragment {

    private View view;

    public Primer_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.l_primer_fragmento,container, false);
        return view;
    }

}
