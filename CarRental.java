package model;

public class CarRental implements BookingItem {
    private String location, date;
    public CarRental(String location, String date) { this.location = location; this.date = date; }
    @Override public String toString() { return "Car at " + location + " on " + date; }
}