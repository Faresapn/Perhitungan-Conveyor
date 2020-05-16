package com.faresa.perhitungankonveyor.ui.screw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import com.faresa.perhitungankonveyor.R;
import com.faresa.perhitungankonveyor.model.DataMaterial;

import java.util.ArrayList;

public class MaterialActivity extends AppCompatActivity implements MaterialAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    MaterialAdapter adapter;
    private ArrayList<DataMaterial> list;

    private String[] materialData;
    private String[] weightData;
    private String[] materialfacData;
    private String[] componentData;
    private String[] seriesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        recyclerView = findViewById(R.id.rv);
        adapter = new MaterialAdapter(getApplicationContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        recyclerView.setAdapter(adapter);
        prepare();
        addItem();
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
        adapter.setOnItemClickListener(MaterialActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
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
    }
}
