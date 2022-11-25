package com.example.week3_fragment_ywca;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdFragment extends Fragment {

    String question = "";
    static Context context;
    interface ThirdFragmentListener {
        void saveClicked(String answer);
        void cancleClicked();
    }

    ThirdFragmentListener listener;


    public static ThirdFragment newInstance(Context c, String questionText) {
        context = c;
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString("qFromA", questionText);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString("qFromA");

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);

        TextView questionText = v.findViewById(R.id.questionFromAct);
        questionText.setText(question);
        EditText answerText = v.findViewById(R.id.userAnswer);

        Button b = v.findViewById(R.id.save);
        Button b2 = v.findViewById(R.id.cancle);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerText.getText().toString().isEmpty()){
                    answerText.setHint("You have to enter the value first ");
                    Toast.makeText(context, "You have to enter the value first ", Toast.LENGTH_SHORT).show();
                }else {
                 listener.saveClicked(answerText.getText().toString());
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.cancleClicked();
            }
        });


        return v;

    }
}