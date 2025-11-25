package model;

public class Flight implements BookingItem {
    private String origin, destination, date; // simple representation
    public Flight(String origin, String dest, String date) { this.origin = origin; this.destination = dest; this.date = date; }
    @Override public String toString() { return "Flight: " + origin + "->" + destination + " on " + date; }
}