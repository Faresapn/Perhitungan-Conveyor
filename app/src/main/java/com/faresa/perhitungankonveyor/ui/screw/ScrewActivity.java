package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faresa.perhitungankonveyor.R;

public class ScrewActivity extends AppCompatActivity {
    String dataMaterial;
    String dataWeight = "";
    String dataMaterialFactor = "";
    String dataComponent = "";
    String dataSeries = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screw);
    }
}
