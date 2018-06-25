package com.gokwh.anastasia.gokwh;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class menu_6 extends Fragment {

    private Button kuliner,elektronik,fashion;

    @Nullable
    @Override
    public View onCreateView(@Nullable  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_6, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("List Konsumen");

        kuliner = (Button)view.findViewById(R.id.kuliner_bt);
        elektronik = (Button)view.findViewById(R.id.elektronik_bt);
        fashion = (Button)view.findViewById(R.id.fashion_bt);

        kuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), kuliner_list.class);
                getActivity().startActivity(intent);
            }
        });

        elektronik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), elektronik_list.class);
                getActivity().startActivity(intent);
            }
        });

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fashion_list.class);
                getActivity().startActivity(intent);
            }
        });
    }
}