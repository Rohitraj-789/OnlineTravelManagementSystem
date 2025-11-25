package model;

import service.ListingService;


public class Admin extends User implements AdminActions {
    public Admin(int id, String name, String email) { super(id, name, email, Role.ADMIN); }


    @Override
    public void dashboard() {
        System.out.println("Admin dashboard for " + name);
    }


    @Override
    public void manageUser(User u) {
        System.out.println("Admin manages user: " + u.getName());
// implement user management logic via DAO
    }


    @Override
    public void approveListing(int listingId) {
        System.out.println("Approved listing: " + listingId);
        ListingService.approve(listingId);
    }
}
