package com.example.many_data_rate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView receive_txt1;
    private EditText transfer_txt1;
    private Button transfer_mars;
    private ImageView gif1;
    private Button transfer_moon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void startGif() {
        Glide.with(this).load(R.drawable.transfer).into(gif1);
    }


    private void initView() {
        receive_txt1 = findViewById(R.id.receive_txt1);
        transfer_txt1 = findViewById(R.id.transfer_text1);
        transfer_mars = findViewById(R.id.transfer_mars);
        transfer_moon = findViewById(R.id.transfer_moon);
        gif1 = findViewById(R.id.gif1);
        transfer_mars.setOnClickListener(this);
        transfer_moon.setOnClickListener(this);
        startGif();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transfer_mars:
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("001", "地球：" + transfer_txt1.getText().toString());
                startActivityForResult(intent, 1);
                break;
            case R.id.transfer_moon:
                Intent intent1 = new Intent(getApplicationContext(), Main3Activity.class);
                intent1.putExtra("002", "地球：" + transfer_txt1.getText().toString());
                startActivityForResult(intent1, 2);
                break;
        }
        transfer_txt1.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(data != null){
                if(requestCode == 1){
                    String extra1 = data.getStringExtra("003");
                    receive_txt1.setText(extra1);
                }else if(requestCode == 2){
                    String extra2 = data.getStringExtra("005");
                    receive_txt1.setText(extra2);
                }
            }
        }
    }