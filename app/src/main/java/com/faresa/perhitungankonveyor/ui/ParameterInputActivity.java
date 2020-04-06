package com.faresa.perhitungankonveyor.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ParameterInputActivity extends AppCompatActivity {
    Spinner spinnerWorking, spinnerPenggerak, spinnerTypeConveyor, spinnerMaterialCondition, spinnerMaterialTransport, spinnerAngle, spinnerbeltwidth, spinnerLump, spinnerBeltype, spinnerGrade, spinnerSurface, spinnerSagging;
    ImageView decline, horizontal, incline;
    ImageView dua, tiga, tigalima, empatlima;
    TextView etSpeedM, etDensityKg, txtCosa, txtCsa, txtcalcu, txtSlope, txtCapacity;
    TextInputLayout etCapacity, etSpeedS, etWrapAngle, etHeightHop, etWidthHop, etLengthSk, etWidthSk, etHoriLength, etLiftHeight, etCarrier, etSlope, etDensity, etSurcharge, etNpt;
    Button hitung,reset,boq,sheet;
    LinearLayout linearLayout;
    double convertSpeed, convertBerat, Qt, Convertslope;

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
        txtSlope = findViewById(R.id.etSlopeAngle);
        dua = findViewById(R.id.duapuluh);
        tiga = findViewById(R.id.tigapuluh);
        txtcalcu = findViewById(R.id.calcu);
        tigalima = findViewById(R.id.tigalima);
        empatlima = findViewById(R.id.empatlima);
        spinnerLump = findViewById(R.id.LumpSize);
        etSpeedS = findViewById(R.id.etSpeedS);
        etSpeedM = findViewById(R.id.etSpeedM);
        etDensityKg = findViewById(R.id.etDensityKg);
        etDensity = findViewById(R.id.etDensity);
        etLiftHeight = findViewById(R.id.etLiftHeight);
        etHoriLength = findViewById(R.id.etHoriLength);
        etCapacity = findViewById(R.id.etCapacity);
        txtCapacity = findViewById(R.id.capa);
        boq = findViewById(R.id.boq);
        sheet = findViewById(R.id.datasheet);

        boq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParameterInputActivity.this,BoqActivity.class);
                startActivity(intent);

            }
        });
        sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParameterInputActivity.this,DataSheetActivity.class);
                startActivity(intent);

            }
        });
        try {


            etLiftHeight.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String horiLengthS = etHoriLength.getEditText().getText().toString().trim();
                    String liftHeightS = etLiftHeight.getEditText().getText().toString().trim();
                    if (!horiLengthS.isEmpty() || !liftHeightS.isEmpty()){
                        double ethorilength = Double.parseDouble(horiLengthS);
                        double etliftheight = Double.parseDouble(liftHeightS);
                        Convertslope = etliftheight / ethorilength;
                        txtSlope.setText(Double.toString(Convertslope));
                    }
                   else {
                       txtSlope.setText("");
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            etHoriLength.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    etHoriLength.getEditText().getText().toString().trim();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            etDensity.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String densityS = etDensity.getEditText().getText().toString().trim();
                    if (!densityS.isEmpty()){
                        final double speed = Double.parseDouble(densityS);
                        convertBerat = speed * 1000;
                        etDensityKg.setText(Double.toString(convertBerat));
                    }else{
                        etDensityKg.setText("");
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            etSpeedS.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String speedS = etSpeedS.getEditText().getText().toString().trim();
                    if (!speedS.isEmpty()){
                        final double speed = Double.parseDouble(speedS);
                        double convertSpeed = speed * 60;
                        etSpeedM.setText(String.valueOf(convertSpeed));
                    }else{
                        etSpeedM.setText("");
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }catch(Exception e){
            Log.d(String.valueOf(e), "TextWatcher");
        }

        etSurcharge = findViewById(R.id.etSurcharge);

        hitung = findViewById(R.id.hitung);
        txtCosa = findViewById(R.id.Cosa);
        txtCsa = findViewById(R.id.Csa);


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
        spinnerbeltwidth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerbeltwidth.getSelectedItem();
                final String fsss = String.valueOf(spinnerbeltwidth.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Log.d("cek", String.valueOf(spinnerbeltwidth.getSelectedItem()));
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

        hitung.setOnClickListener(view -> {
            if (validateEtSurcharge() | validateEtCapacity() | validateEtDensity() | validateEtHoriLength() | validateEtLiftHeight() | validateEtSpeedS()) {
                try {
                    int angle = Integer.parseInt(Objects.requireNonNull(etSurcharge.getEditText()).getText().toString());
                    if (angle == (10)) {
                        txtCosa.setText("0.13");
                    } else if (angle == (20)) {
                        txtCosa.setText("0.16");
                    } else if (angle == (30)) {
                        txtCosa.setText("0.18");
                    } else {
                        Log.d("else", "else");
                        Toast.makeText(this, "Data surcharge tidak valid \n masukan 10/20/30", Toast.LENGTH_LONG).show();
                        txtCosa.setText("");
                    }

                    final double beltWidth = Double.parseDouble(String.valueOf(spinnerbeltwidth.getSelectedItem()));
                    Log.d("belt", String.valueOf(beltWidth));
                    String strCosa = txtCosa.getText().toString();
                    double getCosa = Double.parseDouble(strCosa);
                    double csa = (getCosa * ((0.9 * beltWidth / 1000) - 0.05));
                    String hasilCsa = Double.toString(csa);
                    txtCsa.setText(hasilCsa);
                    double kecepatan = Double.parseDouble(etSpeedM.getText().toString());
                    double densiti = Double.parseDouble(etDensityKg.getText().toString());
                    double SlopeAngel = Double.parseDouble(txtSlope.getText().toString());

                    Qt = 60 * kecepatan * densiti * SlopeAngel * csa;
                    txtcalcu.setText(Double.toString(Qt));
                    Log.d("getcosa", txtCosa.toString());
                    double capacity = Double.parseDouble(etCapacity.getEditText().getText().toString().trim());
                    if (Qt > capacity) {
                        txtCapacity.setText("Acc");
                    } else {
                        txtCapacity.setText("ditolak");
                    }


                } catch (Exception e) {
                    Toast.makeText(this, "Data surcharge tidak valid \n masukan 10/20/30", Toast.LENGTH_LONG).show();
                    txtCosa.setText("");
                    txtCsa.setText("");
                    Log.d("catch", "catch");
                }
            } else {
                Toast.makeText(this, "Mohon Masukan Surcharge Angle", Toast.LENGTH_LONG).show();
                txtCosa.setText("");

            }

        });
    }

    //region validation
    private boolean validateEtSurcharge() {
        String surcharge = (Objects.requireNonNull(etSurcharge.getEditText())).getText().toString().trim();

        if (surcharge.isEmpty()) {
            etSurcharge.setError("Ini tidak boleh kosong");
            return false;
        } else {
            etSurcharge.setError(null);
            return true;
        }
    }
    private boolean validateEtCapacity() {
        String capacity = (Objects.requireNonNull(etCapacity.getEditText())).getText().toString().trim();

        if (capacity.isEmpty()) {
            etCapacity.setError("Ini tidak boleh kosong");
            return false;
        } else {
            etCapacity.setError(null);
            return true;
        }
    }
    private boolean validateEtSpeedS() {
        String speedS = (Objects.requireNonNull(etSpeedS.getEditText())).getText().toString().trim();

        if (speedS.isEmpty()) {
            etSpeedS.setError("Ini tidak boleh kosong");
            return    false;
        } else {
            etSpeedS.setError(null);
            return true;
        }
    }
    private boolean validateEtHoriLength() {
        String horiLength = (Objects.requireNonNull(etHoriLength.getEditText())).getText().toString().trim();

        if (horiLength.isEmpty()) {
            etHoriLength.setError("Ini tidak boleh kosong");
            return false;
        } else {
            etHoriLength.setError(null);
            return true;
        }
    }
    private boolean validateEtLiftHeight() {
        String liftHeight = (Objects.requireNonNull(etLiftHeight.getEditText())).getText().toString().trim();

        if (liftHeight.isEmpty()) {
            etLiftHeight.setError("Ini tidak boleh kosong");
            return false;
        } else {
            etLiftHeight.setError(null);
            return true;
        }
    }

    private boolean validateEtDensity() {
        String density = (Objects.requireNonNull(etDensity.getEditText())).getText().toString().trim();

        if (density.isEmpty()) {
            etDensity.setError("Ini tidak boleh kosong");
            return false;
        } else {
            etDensity.setError(null);
            return true;
        }
    }
//endregion

}
