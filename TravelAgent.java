package model;

public class TravelAgent extends User implements AgentActions {
    public TravelAgent(int id, String name, String email) { super(id, name, email, Role.AGENT); }


    @Override
    public void dashboard() { System.out.println("Agent dashboard for " + name); }


    @Override
    public void addListing(model.Listing<?> listing) {
        System.out.println("Agent added listing: " + listing.getTitle());
// call DAO
    }


    @Override
    public void communicate(String message) {
        System.out.println("Agent message: " + message);
    }
}