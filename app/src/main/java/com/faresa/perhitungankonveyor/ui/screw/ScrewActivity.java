package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.faresa.perhitungankonveyor.R;
import com.faresa.perhitungankonveyor.model.DataMaterial;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

public class ScrewActivity extends AppCompatActivity implements MaterialAdapter.OnItemClickListener{
    String dataMaterial= "";
    String dataWeight = "";
    String dataMaterialFactor = "";
    String dataComponent = "";
    String dataSeries = "";

    double Cfo = 1.1;
    double Fm = 1.4;
    double Ff = 1;
    double Fp = 1;
    double n1 = 0.94;
    double n2 = 0.94;
    double Fo = 1;

    DataMaterial data;
    private String[] materialData;
    private String[] weightData;
    private String[] materialfacData;
    private String[] componentData;
    private String[] seriesData;

    RecyclerView recyclerView;
    MaterialAdapter adapter;
    private ArrayList<DataMaterial> list;
    TextInputLayout etMaterial,etWeight,etMaterialfac,etComponent,etSeries, etC1, etFb,etFd, etNormal,etEquivalent, etSpeed, etLo,etL ;
    Button btnMaterial;
    CardView cardInput, cardHasil;
    LinearLayout linearHitung;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screw);
        data = getIntent().getParcelableExtra("MATERIAL_DATA");
        etMaterial = findViewById(R.id.materialName);
        etWeight = findViewById(R.id.materialWeight);
        etMaterialfac = findViewById(R.id.materialFactor);
        etComponent = findViewById(R.id.materialComponent);
        etSeries = findViewById(R.id.materialSeries);
        cardInput = findViewById(R.id.cardInput);
        etC1 = findViewById(R.id.materialC1);
        etFb = findViewById(R.id.materialFb);
        etFd = findViewById(R.id.materialFd);
        linearHitung = findViewById(R.id.linearHitung);
        cardHasil = findViewById(R.id.cardHasil);

        etNormal = findViewById(R.id.hasilNormal);
        etEquivalent = findViewById(R.id.hasilEquivalent);
        etSpeed = findViewById(R.id.hasilSpeed);
        etLo = findViewById(R.id.hasilLo);
        etL = findViewById(R.id.hasilL);

        etMaterial.getEditText().setFocusable(false);
        etWeight.getEditText().setFocusable(false);
        etMaterialfac.getEditText().setFocusable(false);
        etComponent.getEditText().setFocusable(false);
        etSeries.getEditText().setFocusable(false);
        etC1.getEditText().setFocusable(false);
        etFb.getEditText().setFocusable(false);
        etFd.getEditText().setFocusable(false);

        etNormal.getEditText().setFocusable(false);
        etEquivalent.getEditText().setFocusable(false);
        etSpeed.getEditText().setFocusable(false);
        etLo.getEditText().setFocusable(false);
        etL.getEditText().setFocusable(false);

        try {
            Objects.requireNonNull(etMaterial.getEditText()).setText(data.getMaterial());
            Objects.requireNonNull(etWeight.getEditText()).setText(data.getWeight());
            Objects.requireNonNull(etMaterialfac.getEditText()).setText(data.getMaterialfac());
            Objects.requireNonNull(etComponent.getEditText()).setText(data.getComponent());
            Objects.requireNonNull(etSeries.getEditText()).setText(data.getSeries());
        }catch (Exception e){
            Log.d("catac", "catch");
        }
        String mater = etMaterial.getEditText().getText().toString();
        String getC1 = etComponent.getEditText().getText().toString();
        String getFd = etComponent.getEditText().getText().toString();
        String getFb = etSeries.getEditText().getText().toString();
        Log.d("mater", mater);
        if (mater.equals("")){
            cardInput.setVisibility(View.GONE);
            linearHitung.setVisibility(View.GONE);
            cardHasil.setVisibility(View.GONE);
        }else {
            cardInput.setVisibility(View.VISIBLE);
            linearHitung.setVisibility(View.VISIBLE);
            cardHasil.setVisibility(View.VISIBLE);
        }
        if (!getC1.equals("")){
            switch (getC1) {
                case "10":
                    etC1.getEditText().setText("7");
                    break;
                case "20":
                    etC1.getEditText().setText("62.5");
                    break;
                case "30":
                    etC1.getEditText().setText("109");
                    break;
            }
        }
        if (!getFd.equals("")){
            switch (getFd) {
                case "10":
                    etFd.getEditText().setText("140");
                    break;
                case "20":
                    etFd.getEditText().setText("165");
                    break;
                case "30":
                    etFd.getEditText().setText("180");
                    break;
            }
        }
        if (!getFb.equals("")){
            switch (getFb) {
                case "A":
                    etFb.getEditText().setText("1");
                    break;
                case "B":
                    etFb.getEditText().setText("1.7");
                    break;
                case "C":
                    etFb.getEditText().setText("2");
                    break;
                case "D":
                    etFb.getEditText().setText("4.4");
                    break;
            }
        }
        btnMaterial = findViewById(R.id.btnMaterial);
        btnMaterial.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(ScrewActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.activity_material);
            recyclerView = dialog.findViewById(R.id.rv);
            adapter = new MaterialAdapter(getApplicationContext(), list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
            recyclerView.setAdapter(adapter);
            prepare();
            addItem();
            dialog.show();
        });
    }
    private void prepare() {
        materialData = getResources().getStringArray(R.array.array_material);
        weightData = getResources().getStringArray(R.array.array_weight);
        materialfacData = getResources().getStringArray(R.array.array_materialfac);
        componentData = getResources().getStringArray(R.array.array_component);
        seriesData = getResources().getStringArray(R.array.array_series);

    }

    private void addItem() {
        ArrayList<DataMaterial> list = new ArrayList<>();
        for (int i = 0; i < materialData.length; i++) {
            DataMaterial items = new DataMaterial();
            items.setMaterial(materialData[i]);

            list.add(items);
        }
        adapter = new MaterialAdapter(getApplicationContext(), list);
        adapter.setOnItemClickListener(ScrewActivity.this);
        recyclerView.setAdapter(adapter);
    }
    public void onItemClick(int position) {
        DataMaterial data = new DataMaterial();
        data.setMaterial(materialData[position]);
        data.setWeight(weightData[position]);
        data.setMaterialfac(materialfacData[position]);
        data.setComponent(componentData[position]);
        data.setSeries(seriesData[position]);
        Intent intent = new Intent(getApplication(), ScrewActivity.class);
        intent.putExtra("MATERIAL_DATA", data);
        startActivity(intent);
        finish();
    }

}
