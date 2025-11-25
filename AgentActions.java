package model;

public interface AgentActions {
    void addListing(Listing<?> listing);
    void communicate(String message);
}
