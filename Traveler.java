package model;

public class Traveler extends User implements TravelerActions {
    public Traveler(int id, String name, String email) { super(id, name, email, Role.TRAVELER); }


    @Override
    public void dashboard() { System.out.println("Traveler dashboard for " + name); }


    @Override
    public void book(int listingId) {
        System.out.println(name + " requests booking for listing " + listingId);
    }
}