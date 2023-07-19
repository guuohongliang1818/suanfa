package com.ghl;

public class PointAndSurface {


    public static boolean isPointInCircle(Vector2D cPoint, double cRadius, Vector2D point) {
        double d1 = Distance(cPoint.Lat, cPoint.Lon, point.Lat, point.Lon);
        System.out.println("d1：" + d1);
        //double distance = Math.sqrt(Math.pow(Math.abs(point.X - cPoint.X), 2) + Math.pow(Math.abs(point.Y - cPoint.Y), 2));
        return d1 <= cRadius;
    }

    public static double Distance(double lon1, double lat1, double lon2, double lat2) {
        double R = 6378137; //地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        double sa2 = Math.sin((lat1 - lat2) / 2.0);
        double sb2 = Math.sin(((lon1 - lon2) * Math.PI / 180.0) / 2.0);
        return 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
    }
}
