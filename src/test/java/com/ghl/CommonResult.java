package com.ghl;

public class CommonResult {
    public static final String BAIDU_LBS_TYPE = "bd09ll";
    public static double pi = 3.1415926535897932384626;
    public static double a = 6378245.0;
    public static double ee = 0.00669342162296594323;

    /**
     * 北斗坐标系度分秒计算
     * @param msg
     * @return
     */
    public static GPS str_To_Gps84(String msg){
        double lat = 0;
        double lon = 0;
        String[] split = msg.split(",");
        if (split[4].equals("N") || split[4].equals("S")){
            int i = split[3].indexOf(".");
            String latInt = split[3].substring(0, i - 2);
            String latDec = split[3].substring(i-2);
            int i1 = split[5].indexOf(".");
            String lonInt = split[5].substring(0, i1-2);
            String lonDec = split[5].substring(i1-2);
            lat = Integer.parseInt(latInt) + Double.parseDouble(latDec)/60;
            lon = Integer.parseInt(lonInt) + Double.parseDouble(lonDec)/60;
            System.out.println("latInt = "+ latInt);
            System.out.println("latDec = "+ latDec);
            System.out.println("lonInt = "+ lonInt);
            System.out.println("lonDec = "+ lonDec);
            System.out.println("lat = "+ lat);
            System.out.println("lon = "+ lon);
        } else {
            return null;
        }

        return new GPS(lat,lon);
    }




    /**
     * 84 to 火星坐标系 (GCJ-02)
     * @param lat
     * @param lon
     */
    public static GPS gps84_To_Gcj02(double lat, double lon) {
        if (outOfChina(lat, lon))
        {
            return null;
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new GPS(mgLat, mgLon);
    }

    /**
     * * 火星坐标系 (GCJ-02) to 84
     * * @param lon * @param lat * @return
     */
    public static GPS gcj_To_Gps84(double lat, double lon) {
        GPS gps = transform(lat, lon);
        double lontitude = lon * 2 - gps.getLon();
        double latitude = lat * 2 - gps.getLat();
        return new GPS(latitude, lontitude);
    }

    /**
     * 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param gg_lat
     * @param gg_lon
     */
    public static GPS gcj02_To_Bd09(double gg_lat, double gg_lon) {
        double x = gg_lon, y = gg_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
        double bd_lon = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        return new GPS(bd_lat, bd_lon);
    }

    /**
     * * 将 BD-09 坐标转换成GCJ-02 坐标 *
     * * @param
     * bd_lat * @param bd_lon * @return
     */
    public static GPS bd09_To_Gcj02(double bd_lat, double bd_lon) {
        double x = bd_lon - 0.0065;
        double y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
        double gg_lon = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        return new GPS(gg_lat, gg_lon);
    }

    /**
     * (BD-09)-->84
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static GPS bd09_To_Gps84(double bd_lat, double bd_lon) {

        GPS gcj02 = bd09_To_Gcj02(bd_lat, bd_lon);
        GPS map84 = gcj_To_Gps84(gcj02.getLat(),
                gcj02.getLon());
        return map84;

    }

    /**
     * is or not outOfChina
     * @param lat
     * @param lon
     * @return
     */
    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347)
            return true;
        if (lat < 0.8293 || lat > 55.8271)
            return true;
        return false;
    }

    public static GPS transform(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new GPS(lat, lon);
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new GPS(mgLat, mgLon);
    }

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
                + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }


    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
                * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0
                * pi)) * 2.0 / 3.0;
        return ret;
    }
    //求两坐标距离
    public static double distance(double lonA,double latA,double lonB,double latB){
        int earthR = 6371000;
        double x = Math.cos(latA * pi / 180.) * Math.cos(latB * pi / 180.) * Math.cos((lonA - lonB) * pi / 180);
        double y = Math.sin(latA * pi / 180.) * Math.sin(latB * pi / 180.);
        double s = x + y;
        if (s > 1) s = 1;
        if (s < -1) s = -1;
        double alpha = Math.acos(s);
        double distance = alpha * earthR;
        return distance;
    }
    //重载，根据两个点求距离
    public static double distance(GPS p1,GPS p2){
        return distance(p1.getLon(), p1.getLat(), p2.getLon(), p2.getLat());
    }


    public static void main(String[] args) {

        String msg = "$GNRMC,083735.000,A,2429.53531,N,11810.78036,E,0.54,171.11,190621,,,A*7E";

        //GPS gps2 = CommonResult.str_To_Gps84(msg);
        GPS gps2 = new GPS(41.85839,97.101761);

        GPS gps = CommonResult.gps84_To_Gcj02(gps2.getLat(), gps2.getLon());
        System.out.println(gps);
    }
}
