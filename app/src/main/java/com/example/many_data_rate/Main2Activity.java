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


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView receive_txt2;
    private EditText transfer_txt2;
    private ImageView gif2;
    private Button transfer_earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void startGif() {
        Glide.with(this).load(R.drawable.transfer).into(gif2);
    }



    private void initView() {
        receive_txt2 = findViewById(R.id.receive_txt2);
        receive_txt2.setText(getIntent().getStringExtra("001"));
        transfer_txt2 = findViewById(R.id.transfer_txt2);
        transfer_earth = findViewById(R.id.transfer_earth);
        gif2 = findViewById(R.id.gif2);
        transfer_earth.setOnClickListener(this);
        startGif();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.transfer_earth:
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                intent1.putExtra("003","火星：" + transfer_txt2.getText().toString());
                setResult(1,intent1);
                transfer_txt2.setText("");
                finish();
                break;
        }
    }

}