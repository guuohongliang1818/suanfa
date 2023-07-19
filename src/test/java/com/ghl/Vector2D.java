package com.ghl;

public class Vector2D {
    public double Lat;
    public double Lon;

    public Vector2D(double lat, double lon) {
        Lat = lat;
        Lon = lon;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        Lon = lon;
    }
}