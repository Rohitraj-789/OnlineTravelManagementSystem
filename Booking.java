package model;

import java.time.LocalDateTime;

public class Booking {
    private Integer id; // nullable so DB-generated id can be set later
    private int userId;
    private int listingId;
    private LocalDateTime time;

    // Constructor used when letting DB generate ID
    public Booking(int userId, int listingId) {
        this.userId = userId;
        this.listingId = listingId;
        this.time = LocalDateTime.now();
    }

    // Optional constructor if you want to set an id manually
    public Booking(int id, int userId, int listingId) {
        this.id = id;
        this.userId = userId;
        this.listingId = listingId;
        this.time = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public int getUserId() { return userId; }
    public int getListingId() { return listingId; }
    public LocalDateTime getTime() { return time; }
}
