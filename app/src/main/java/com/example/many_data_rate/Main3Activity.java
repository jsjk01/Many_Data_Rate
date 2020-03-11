package com.example.many_data_rate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView receive_txt3;
    private ImageView gif3;
    private Button transfer_earth2;
    private EditText transfer_txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void startGif() {
        Glide.with(this).load(R.drawable.transfer).into(gif3);
    }


    private void initView() {
        receive_txt3 = findViewById(R.id.receive_txt3);
        receive_txt3.setText(getIntent().getStringExtra("002"));//02是地球发往月球
        transfer_txt3 = findViewById(R.id.transfer_txt3);
        transfer_earth2 = findViewById(R.id.transfer_earth2);
        gif3 = findViewById(R.id.gif3);
        transfer_earth2.setOnClickListener(this);
        startGif();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.transfer_earth2:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("005","月球：" + transfer_txt3.getText().toString());
                setResult(2,intent);
                transfer_txt3.setText("");
                finish();
                break;
        }
    }
}