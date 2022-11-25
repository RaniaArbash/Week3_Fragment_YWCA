package com.example.week3_fragment_ywca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener , ThirdFragment.ThirdFragmentListener
    // MVVM - fragment stack
{
    FragmentManager fragmentManager = getSupportFragmentManager();
    ImageView imageViewInSecondContanier;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ftos = findViewById(R.id.ftos);
        ftos.setOnClickListener(this);

        answer = findViewById(R.id.answer);

        Button stof = findViewById(R.id.stof);
        stof.setOnClickListener(this);

        Button addRemove = findViewById(R.id.addremove);
        addRemove.setOnClickListener(this);

        Button alert = findViewById(R.id.alert);
        alert.setOnClickListener(this);

        imageViewInSecondContanier = findViewById(R.id.imageInSecondContainer);
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
            case R.id.alert:
                FragmentAlertDialog.newInstance("Thank You for your dontaion!!").show(fragmentManager,FragmentAlertDialog.TAG);
                break;
            case R.id.addremove:
                Fragment f =  fragmentManager.findFragmentById(R.id.secondcontainer);
                if ((f != null) && f.getClass() == ThirdFragment.class) {// the container has a fragment objct ==> remove it
                    imageViewInSecondContanier.setVisibility(View.VISIBLE);
                    answer.setVisibility(View.VISIBLE);
                    (fragmentManager.beginTransaction()).remove(f).commit();
                    break;
                }
                else{
                // send a question to the fragment
                ThirdFragment tf = ThirdFragment.newInstance(this,"What is your City?");
                tf.listener = this;
                imageViewInSecondContanier.setVisibility(View.INVISIBLE);
                    answer.setVisibility(View.INVISIBLE);

                    (fragmentManager.beginTransaction()).add(R.id.secondcontainer, tf).commit();


                break;
            }
        }
    }



    @Override
    public void saveClicked(String a) {
        Toast.makeText(this,"The answer is  " + a , Toast.LENGTH_LONG).show();

           Fragment f =  fragmentManager.findFragmentById(R.id.secondcontainer);
        imageViewInSecondContanier.setVisibility(View.VISIBLE);
        (fragmentManager.beginTransaction()).remove(f).commit();

        answer.setVisibility(View.VISIBLE);
        answer.setText(a);



    }

    @Override
    public void cancleClicked() {
        Toast.makeText(this,"The user clicked Cancel Button " , Toast.LENGTH_LONG).show();
        Fragment f =  fragmentManager.findFragmentById(R.id.secondcontainer);
        imageViewInSecondContanier.setVisibility(View.VISIBLE);
        (fragmentManager.beginTransaction()).remove(f).commit();
        answer.setVisibility(View.INVISIBLE);
    }
}