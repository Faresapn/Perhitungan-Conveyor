package com.faresa.perhitungankonveyor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faresa.perhitungankonveyor.ui.ParameterInputActivity;
import com.faresa.perhitungankonveyor.ui.screw.MaterialActivity;
import com.faresa.perhitungankonveyor.ui.screw.ScrewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onViewClicked() {
        Intent intent5 = new Intent(MainActivity.this, MaterialActivity.class);
        startActivity(intent5);
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        Intent intent6 = new Intent(MainActivity.this, ParameterInputActivity.class);
        startActivity(intent6);
    }


}
