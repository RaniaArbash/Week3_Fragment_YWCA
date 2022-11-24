package com.example.week3_fragment_ywca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment {

    interface ThirdFragmentListener {
        void firstFragmentButtonClicked();
        void secondFragmentButtonClicked();
    }

    ThirdFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);

        Button b = v.findViewById(R.id.firstBut);
        Button b2 = v.findViewById(R.id.secondBut);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.firstFragmentButtonClicked();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.secondFragmentButtonClicked();
            }
        });


        return v;

    }
}