package com.example.week3_fragment_ywca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener , ThirdFragment.ThirdFragmentListener
{
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ftos = findViewById(R.id.ftos);
        ftos.setOnClickListener(this);

        Button stof = findViewById(R.id.stof);
        stof.setOnClickListener(this);

        Button addRemove = findViewById(R.id.addremove);
        addRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ftos:
                (fragmentManager.beginTransaction()).
                        replace(R.id.fragment_container_view, SecondFragment.class, null)
                        .commit();
                break;
            case R.id.stof:
                (fragmentManager.beginTransaction()).
                        replace(R.id.fragment_container_view, FirstFragment.class, null)
                        .commit();
                break;
            case R.id.addremove:
                Fragment f =  fragmentManager.findFragmentById(R.id.secondcontainer);
                if ((f != null) && f.getClass() == ThirdFragment.class) {// the container has a fragment objct ==> remove it
                    (fragmentManager.beginTransaction()).remove(f).commit();
                    break;
                }
                else{

                ThirdFragment tf = new ThirdFragment();
                tf.listener = this;
                (fragmentManager.beginTransaction()).add(R.id.secondcontainer, tf).commit();
                break;
            }
        }
    }



    @Override
    public void firstFragmentButtonClicked() {
        Toast.makeText(this,"First Button in Third fragment is clicked " , Toast.LENGTH_LONG).show();

    }

    @Override
    public void secondFragmentButtonClicked() {
        Toast.makeText(this,"Second Button in Third fragment is clicked " , Toast.LENGTH_LONG).show();

    }
}