package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faresa.perhitungankonveyor.R;

public class HasilScrewActivity extends AppCompatActivity {
    String hpf, hpm, hp, hp2, torque, torque2, angle, hph, incHp, incHp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_screw);

        hpf = getIntent().getStringExtra("hpf");
        hpm = getIntent().getStringExtra("hpm");
        hp = getIntent().getStringExtra("hp");
        hp2 = getIntent().getStringExtra("hp2");
        torque = getIntent().getStringExtra("torque");
        torque2 = getIntent().getStringExtra("torque2");
        angle = getIntent().getStringExtra("angle");
        hph = getIntent().getStringExtra("hph");
        incHp = getIntent().getStringExtra("inc_hp");
        incHp2 = getIntent().getStringExtra("inc_hp2");


    }
}
