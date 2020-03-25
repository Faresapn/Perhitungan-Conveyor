package com.faresa.perhitungankonveyor.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.faresa.perhitungankonveyor.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ParameterInputActivity extends AppCompatActivity {
    Spinner spinnerWorking, spinnerPenggerak, spinnerTypeConveyor, spinnerMaterialCondition, spinnerMaterialTransport, spinnerAngle, spinnerbeltwidth, spinnerLump, spinnerBeltype, spinnerGrade, spinnerSurface, spinnerSagging;
    ImageView decline, horizontal, incline;
    ImageView dua, tiga, tigalima, empatlima;
    TextView etSpeedM, etDensityKg, txtCosa, txtCsa;
    TextInputLayout etCapacity, etSpeedS, etWrapAngle, etHeightHop, etWidthHop, etLengthSk, etWidthSk, etHoriLength, etLiftHeight, etSlopeAngle, etCarrier, etSlope, etDensity, etSurcharge, etNpt;
    Button hitung;
    LinearLayout linearLayout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter_input);
        spinnerbeltwidth = findViewById(R.id.beltWidth);
        spinnerWorking = findViewById(R.id.spinner_working_data);
        spinnerPenggerak = findViewById(R.id.spinner_tipe_penggerak);
        spinnerTypeConveyor = findViewById(R.id.spinner_type_conveyor);
        spinnerMaterialCondition = findViewById(R.id.ConditionMaterial);
        spinnerMaterialTransport = findViewById(R.id.moveMaterial);
        spinnerBeltype = findViewById(R.id.beltType);
        spinnerGrade = findViewById(R.id.spinner_grade);
        spinnerSurface = findViewById(R.id.spinner_surface);
        spinnerSagging = findViewById(R.id.spinner_sagging);
        spinnerAngle = findViewById(R.id.angle);
        decline = findViewById(R.id.decline);
        horizontal = findViewById(R.id.hori);
        incline = findViewById(R.id.incline);
        dua = findViewById(R.id.duapuluh);
        tiga = findViewById(R.id.tigapuluh);
        tigalima = findViewById(R.id.tigalima);
        empatlima = findViewById(R.id.empatlima);
        spinnerLump = findViewById(R.id.LumpSize);

        etSurcharge = findViewById(R.id.etSurcharge);

        hitung = findViewById(R.id.hitung);
        txtCosa = findViewById(R.id.Cosa);
        txtCsa = findViewById(R.id.Csa);


        hitung.setOnClickListener(view -> {
            try {
                int angle = Integer.parseInt(Objects.requireNonNull(etSurcharge.getEditText()).getText().toString());
                if (angle == (10)) {
                    txtCosa.setText("0,13");
                } else if (angle == (20)) {
                    txtCosa.setText("0,16");
                } else if (angle == (30)) {
                    txtCosa.setText("0,18");
                } else {
                    Log.d("else", "else");
                    Toast.makeText(this, "Data angle tidak valid 10/20/30", Toast.LENGTH_LONG).show();
                }
                String beltWidth =spinnerbeltwidth.getSelectedItem().toString();
                Log.d("belt", beltWidth);
                double csa =  (angle*((0.9*400/1000)-0.05 ));
                String hasilCsa = Double.toString(csa);
                txtCsa.setText(hasilCsa);
            } catch (Exception e) {
                Log.d("catch", "catch");
            }
        });

        //region Spinner
        //items working
        ArrayAdapter<CharSequence> adapterWorking = ArrayAdapter.createFromResource(this,
                R.array.working_data, R.layout.spinner_items);
        adapterWorking.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWorking.setAdapter(adapterWorking);
        spinnerWorking.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerWorking.getSelectedItemId();
                Log.d("cekidott", String.valueOf(spinnerWorking.getSelectedItemId()));
                switch (position) {

                    case 0:
                        horizontal.setVisibility(VISIBLE);
                        decline.setVisibility(GONE);
                        incline.setVisibility(GONE);
                        break;
                    case 1:
                        horizontal.setVisibility(GONE);
                        decline.setVisibility(GONE);
                        incline.setVisibility(VISIBLE);
                        break;
                    case 2:
                        horizontal.setVisibility(GONE);
                        decline.setVisibility(VISIBLE);
                        incline.setVisibility(GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterPenggerak = ArrayAdapter.createFromResource(this,
                R.array.tipe_penggerak, R.layout.spinner_items);
        adapterPenggerak.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPenggerak.setAdapter(adapterPenggerak);

        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this,
                R.array.tipe_konveyor, R.layout.spinner_items);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeConveyor.setAdapter(adapterType);


        //items conveyor
        ArrayAdapter<CharSequence> adapterAngle = ArrayAdapter.createFromResource(this,
                R.array.angle, R.layout.spinner_items);
        adapterAngle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAngle.setAdapter(adapterAngle);
        spinnerAngle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerAngle.getSelectedItemId();
                Log.d("cekidott", String.valueOf(spinnerAngle.getSelectedItemId()));
                switch (position) {

                    case 0:
                        dua.setVisibility(VISIBLE);
                        tiga.setVisibility(GONE);
                        tigalima.setVisibility(GONE);
                        empatlima.setVisibility(GONE);
                        break;
                    case 1:
                        dua.setVisibility(GONE);
                        tiga.setVisibility(VISIBLE);
                        tigalima.setVisibility(GONE);
                        empatlima.setVisibility(GONE);
                        break;
                    case 2:
                        dua.setVisibility(GONE);
                        tiga.setVisibility(GONE);
                        tigalima.setVisibility(VISIBLE);
                        empatlima.setVisibility(GONE);
                        break;
                    case 3:
                        dua.setVisibility(GONE);
                        tiga.setVisibility(GONE);
                        tigalima.setVisibility(GONE);
                        empatlima.setVisibility(VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //items belt
        ArrayAdapter<CharSequence> adapterBelt = ArrayAdapter.createFromResource(this,
                R.array.beltWidth, R.layout.spinner_items);
        adapterBelt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbeltwidth.setAdapter(adapterBelt);

        ArrayAdapter<CharSequence> adapterBeltTp = ArrayAdapter.createFromResource(this,
                R.array.beltType, R.layout.spinner_items);
        adapterBeltTp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBeltype.setAdapter(adapterBeltTp);

        ArrayAdapter<CharSequence> adapterGrade = ArrayAdapter.createFromResource(this,
                R.array.gradeCover, R.layout.spinner_items);
        adapterGrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrade.setAdapter(adapterGrade);

        ArrayAdapter<CharSequence> adapterSurface = ArrayAdapter.createFromResource(this,
                R.array.surfaceType, R.layout.spinner_items);
        adapterSurface.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSurface.setAdapter(adapterSurface);

        ArrayAdapter<CharSequence> adapterSagging = ArrayAdapter.createFromResource(this,
                R.array.beltSagging, R.layout.spinner_items);
        adapterSagging.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSagging.setAdapter(adapterSagging);


        //items material
        ArrayAdapter<CharSequence> adapterLump = ArrayAdapter.createFromResource(this,
                R.array.lumpSize, R.layout.spinner_items);
        adapterLump.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLump.setAdapter(adapterLump);

        ArrayAdapter<CharSequence> adapterCondition = ArrayAdapter.createFromResource(this,
                R.array.kondisi_material, R.layout.spinner_items);
        adapterCondition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaterialCondition.setAdapter(adapterCondition);

        ArrayAdapter<CharSequence> adapterTransport = ArrayAdapter.createFromResource(this,
                R.array.moveMaterial, R.layout.spinner_items);
        adapterTransport.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaterialTransport.setAdapter(adapterTransport);

        //endregion
    }

}
