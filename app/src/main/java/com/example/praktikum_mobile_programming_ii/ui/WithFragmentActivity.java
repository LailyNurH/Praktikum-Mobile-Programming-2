package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WithFragmentActivity extends AppCompatActivity {
    Button btn_fragment1,btn_fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment);

        btn_fragment1 = findViewById(R.id.btn_fragment1);
        btn_fragment2 = findViewById(R.id.btn_fragment2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new com.example.praktikum_mobile_programming_ii.FirstFragment());

            }
        });
        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new com.example.praktikum_mobile_programming_ii.SecondFragment());


            }
        });
    }

    private  void loadFragment (Fragment fragment){
        //Create a Fragment Manager
        FragmentManager fm = getSupportFragmentManager();

        //Create a fragment transaction to begin transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        //Replace the Framelayout with new fragment
        fragmentTransaction.replace(R.id.frame_container,fragment);

        fragmentTransaction.commit();//Save the changes
    }
}