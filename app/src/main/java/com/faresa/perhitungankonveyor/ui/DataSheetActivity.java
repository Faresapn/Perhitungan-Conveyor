package com.faresa.perhitungankonveyor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.faresa.perhitungankonveyor.R;

public class DataSheetActivity extends AppCompatActivity {
    TextView sheetLiftHeight, slope, carrier, returnPitch,coefSlope, typeDrive, direction, designCapacity,speedSec,speedMin ;
    String getLiftHeight, getSlope, getCarrier, getReturnPitch, getCoefSlope, getTypeDrive, getDirection,getDesignCapa, getSpeedSec, getSpeedMin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sheet);

        sheetLiftHeight = findViewById(R.id.sheetLiftHeight);
        slope = findViewById(R.id.sheetSlope);
        carrier = findViewById(R.id.sheetCarrierP);
        returnPitch = findViewById(R.id.sheetReturnP);
        coefSlope = findViewById(R.id.sheetCoef);
        typeDrive = findViewById(R.id.sheetTypeDrive);
        direction = findViewById(R.id.sheetDirection);
        designCapacity = findViewById(R.id.sheetDesignCapacity);
        speedSec = findViewById(R.id.sheetSpeed);
        speedMin = findViewById(R.id.sheetSpeedConvert);

        getLiftHeight = getIntent().getStringExtra("lift");
        getSlope = getIntent().getStringExtra("slope");
        getCarrier = getIntent().getStringExtra("carrier");
        getReturnPitch = getIntent().getStringExtra("return");
        getCoefSlope = getIntent().getStringExtra("coefSlope");
        getTypeDrive = getIntent().getStringExtra("typeDrive");
        getDirection = getIntent().getStringExtra("direction");
        getDesignCapa = getIntent().getStringExtra("designCapacity");
        getSpeedSec = getIntent().getStringExtra("speedSec");
        getSpeedMin = getIntent().getStringExtra("speedMin");

        sheetLiftHeight.setText(getLiftHeight);
        slope.setText(getSlope);
        carrier.setText(getCarrier);
        returnPitch.setText(getReturnPitch);
        coefSlope.setText(getCoefSlope);
        typeDrive.setText(getTypeDrive);
        direction.setText(getDirection);
        designCapacity.setText(getDesignCapa);
        speedSec.setText(getSpeedSec);
        speedMin.setText(getSpeedMin);

    }
}
