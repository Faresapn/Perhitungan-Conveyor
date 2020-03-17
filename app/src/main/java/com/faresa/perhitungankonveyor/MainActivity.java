package com.faresa.perhitungankonveyor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faresa.perhitungankonveyor.ui.BoqActivity;
import com.faresa.perhitungankonveyor.ui.DataSheetActivity;
import com.faresa.perhitungankonveyor.ui.ParameterInputActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onViewClicked() {
        Intent intent5 = new Intent(MainActivity.this, DataSheetActivity.class);
        startActivity(intent5);
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        Intent intent6 = new Intent(MainActivity.this, ParameterInputActivity.class);
        startActivity(intent6);
    }

    @OnClick(R.id.button3)
    public void onButton3Clicked() {
        Intent intent7 = new Intent(MainActivity.this, BoqActivity.class);
        startActivity(intent7);
    }
}
