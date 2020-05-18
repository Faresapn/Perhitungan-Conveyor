package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faresa.perhitungankonveyor.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class HasilScrewActivity extends AppCompatActivity {
    String hpf, hpm, hp, hp2, torque, torque2, angle, hph, incHp, incHp2;
    TextInputLayout horiHpf, horiHpm, horiHp, horiHp2, horiTorque, horiTorque2;
    TextInputLayout inclineAngle, inclineHph, inclineHp, inclineHp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_screw);

        horiHpf = findViewById(R.id.hasilHpf);
        horiHpm = findViewById(R.id.hasilHpm);
        horiHp = findViewById(R.id.hasilHp);
        horiHp2 = findViewById(R.id.hasilHp2);
        horiTorque = findViewById(R.id.hasilTorque);
        horiTorque2 = findViewById(R.id.hasilTorque2);

        inclineAngle = findViewById(R.id.inclineAngle);
        inclineHph = findViewById(R.id.inclineHph);
        inclineHp = findViewById(R.id.inclineHp);
        inclineHp2 = findViewById(R.id.inclineHp2);

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

        Objects.requireNonNull(horiHpf.getEditText()).setText(hpf);
        Objects.requireNonNull(horiHpm.getEditText()).setText(hpm);
        Objects.requireNonNull(horiHp.getEditText()).setText(hp);
        Objects.requireNonNull(horiHp2.getEditText()).setText(hp2);
        Objects.requireNonNull(horiTorque.getEditText()).setText(torque);
        Objects.requireNonNull(horiTorque2.getEditText()).setText(torque2);

        Objects.requireNonNull(inclineAngle.getEditText()).setText(angle);
        Objects.requireNonNull(inclineHph.getEditText()).setText(hph);
        Objects.requireNonNull(inclineHp.getEditText()).setText(incHp);
        Objects.requireNonNull(inclineHp2.getEditText()).setText(incHp2);


    }
}
