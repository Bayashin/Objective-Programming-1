package jp.ac.ait.k21099;

public class Datum {
    private double latitude;
    private double longitude;
    private double distance;
    private String name;

    public Datum(){}

    public Datum(double latitude, double longitude, double distance, String name){
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public double getDistance() {
        return distance;
    }
    public String getName() {
        return name;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }
    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        return String.format("{latitude: %f, longitude: %f, distance: %f, name: %s}",latitude,longitude,distance,name);
    }

}
