package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.faresa.perhitungankonveyor.R;
import com.faresa.perhitungankonveyor.model.DataMaterial;

import java.util.ArrayList;

public class ScrewActivity extends AppCompatActivity implements MaterialAdapter.OnItemClickListener{
    String dataMaterial;
    String dataWeight = "";
    String dataMaterialFactor = "";
    String dataComponent = "";
    String dataSeries = "";

    private String[] materialData;
    private String[] weightData;
    private String[] materialfacData;
    private String[] componentData;
    private String[] seriesData;

    RecyclerView recyclerView;
    MaterialAdapter adapter;
    private ArrayList<DataMaterial> list;

    Button btnMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screw);
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
        intent.putExtra("DETAIL_DATA", data);
        startActivity(intent);
        finish();
    }
}
