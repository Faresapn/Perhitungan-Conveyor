package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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

    DataMaterial data;
    private String[] materialData;
    private String[] weightData;
    private String[] materialfacData;
    private String[] componentData;
    private String[] seriesData;

    RecyclerView recyclerView;
    MaterialAdapter adapter;
    private ArrayList<DataMaterial> list;
    TextInputLayout etMaterial,etWeight,etMaterialfac,etComponent,etSeries;
    Button btnMaterial;

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

        etMaterial.setEnabled(false);
        etWeight.setEnabled(false);
        etMaterialfac.setEnabled(false);
        etComponent.setEnabled(false);
        etSeries.setEnabled(false);

        try {
            Objects.requireNonNull(etMaterial.getEditText()).setText(data.getMaterial());
            Objects.requireNonNull(etWeight.getEditText()).setText(data.getWeight());
            Objects.requireNonNull(etMaterialfac.getEditText()).setText(data.getMaterialfac());
            Objects.requireNonNull(etComponent.getEditText()).setText(data.getComponent());
            Objects.requireNonNull(etSeries.getEditText()).setText(data.getSeries());
        }catch (Exception e){
            Log.d("catac", "catch");
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
