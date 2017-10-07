package com.example.asjie.homework4;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    Button ent;
    Button init;
    ImageView img;

    int ro=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rg2 = (RadioGroup)findViewById(R.id.rg2);
        ent= (Button)findViewById(R.id.ent);
        init = (Button)findViewById(R.id.init);
        img=(ImageView)findViewById(R.id.img);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
               if(rg2.getCheckedRadioButtonId()==-1)
                   Toast.makeText(getApplicationContext(),"각도를 선택 해주세요",Toast.LENGTH_SHORT).show();
                else
                    ent.setVisibility(View.VISIBLE);
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(rg1.getCheckedRadioButtonId()==-1)
                    Toast.makeText(getApplicationContext(),"방향을 선택 해주세요",Toast.LENGTH_SHORT).show();
                else
                    ent.setVisibility(View.VISIBLE);
            }
        });

        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg2.getCheckedRadioButtonId())
                {
                    case R.id.ro15:
                        ro=15;
                        break;
                    case R.id.ro30:
                        ro=30;
                        break;
                    case R.id.ro45:
                        ro=45;
                        break;
                    case R.id.ro90:
                        ro=90;
                        break;
                }

                switch (rg1.getCheckedRadioButtonId())
                {
                    case R.id.clock:
                        img.setRotation(ro);
                        break;
                    case R.id.coclock:
                        img.setRotation(360-ro);
                        break;
                }
            }
        });

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg1.clearCheck();
                rg2.clearCheck();
                ent.setVisibility(View.GONE);
                img.setRotation(0);
            }
        });
    }
}
