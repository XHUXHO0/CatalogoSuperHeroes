package com.example.catalogo_super;

import android.os.Parcel;
import android.os.Parcelable;

public class Superhero implements Parcelable {
    private String name;
    private String alterego;
    private String bio;
    private Float power;

    public Superhero(String name, String alterego, String bio, Float power) {
        this.name = name;
        this.alterego = alterego;
        this.bio = bio;
        this.power = power;
    }

    protected Superhero(Parcel in) {
        name = in.readString();
        alterego = in.readString();
        bio = in.readString();
        if (in.readByte() == 0) {
            power = null;
        } else {
            power = in.readFloat();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(alterego);
        dest.writeString(bio);
        if (power == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(power);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Superhero> CREATOR = new Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel in) {
            return new Superhero(in);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getAlterego() {
        return alterego;
    }

    public String getBio() {
        return bio;
    }

    public Float getPower() {
        return power;
    }
}
