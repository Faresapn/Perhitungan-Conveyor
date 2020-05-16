package com.faresa.perhitungankonveyor.ui.screw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faresa.perhitungankonveyor.R;
import com.faresa.perhitungankonveyor.model.DataMaterial;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.ViewHolder>{
    private Context context;
    private ArrayList<DataMaterial> list;
    private OnItemClickListener mListener;

    public MaterialAdapter(Context context, ArrayList<DataMaterial> list) {
        this.context = context;
        this.list = list;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MaterialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.items_list_material, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialAdapter.ViewHolder holder, int position) {
        holder.material.setText(list.get(position).getMaterial());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView material;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            material = itemView.findViewById(R.id.txtMaterial);

            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
