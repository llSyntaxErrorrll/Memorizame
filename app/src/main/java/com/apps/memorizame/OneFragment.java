package com.apps.memorizame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OneFragment extends Fragment {

    View view;
    TextView TxtTitle;
    String title;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.primer_fracmento,container,false);
        TxtTitle = (TextView)view.findViewById(R.id.TxtId);
        if(getArguments()!= null){
            title = getArguments().getString("title");
        }
        TxtTitle.setText(title);
        return view;
    }


}
