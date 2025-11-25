package model;

import java.util.concurrent.atomic.AtomicInteger;


public class Listing<T extends BookingItem> {
    private int id;
    private String title;
    private T item;
    private volatile boolean approved;
    private AtomicInteger availableUnits = new AtomicInteger(1);


    public Listing(int id, String title, T item, int units) {
        this.id = id; this.title = title; this.item = item; this.availableUnits.set(units);
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public T getItem() { return item; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean a) { this.approved = a; }
    public int getAvailableUnits() { return availableUnits.get(); }


    // synchronized booking at listing-level for thread-safety
    public synchronized boolean reserveOne() {
        if (!approved) return false;
        if (availableUnits.get() <= 0) return false;
        availableUnits.decrementAndGet();
        return true;
    }

    public void incrementUnits() {
    }
}