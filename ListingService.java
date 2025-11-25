package service;

import java.util.*;
import model.Listing;


// Minimal in-memory listing store for demo (Collections & Generics)
public class ListingService {
    private static final Map<Integer, Listing<?>> listings = new HashMap<>();


    public static void register(Listing<?> l) { listings.put(l.getId(), l); }
    public static Listing<?> find(int id) { return listings.get(id); }
    public static void approve(int id) {
        Listing<?> l = listings.get(id); if (l != null) l.setApproved(true);
    }
}