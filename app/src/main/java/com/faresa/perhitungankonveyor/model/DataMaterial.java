package com.faresa.perhitungankonveyor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataMaterial implements Parcelable {
    private String material, weight, materialfac,component,series;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaterialfac() {
        return materialfac;
    }

    public void setMaterialfac(String materialfac) {
        this.materialfac = materialfac;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.material);
        dest.writeString(this.weight);
        dest.writeString(this.materialfac);
        dest.writeString(this.component);
        dest.writeString(this.series);
    }

    public DataMaterial() {
    }

    protected DataMaterial(Parcel in) {
        this.material = in.readString();
        this.weight = in.readString();
        this.materialfac = in.readString();
        this.component = in.readString();
        this.series = in.readString();
    }

    public static final Parcelable.Creator<DataMaterial> CREATOR = new Parcelable.Creator<DataMaterial>() {
        @Override
        public DataMaterial createFromParcel(Parcel source) {
            return new DataMaterial(source);
        }

        @Override
        public DataMaterial[] newArray(int size) {
            return new DataMaterial[size];
        }
    };
}
