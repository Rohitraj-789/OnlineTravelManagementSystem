package model;

public class Hotel implements BookingItem {
    private String location, date;
    public Hotel(String location, String date) { this.location = location; this.date = date; }
    @Override public String toString() { return "Hotel at " + location + " on " + date; }
}