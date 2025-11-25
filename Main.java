package app;

import dao.QueryExecutor;

public class Main {
    public static void main(String[] args) throws Exception {

        // EXAMPLE 1 — INSERT from IntelliJ
        QueryExecutor.runQuery(
                "INSERT INTO users (id, name, email, role) VALUES (4, 'Raman', 'rajiv@example.com', 'Tourist')"
        );

        // EXAMPLE 2 — SELECT (result printed in console)
        QueryExecutor.runQuery("SELECT * FROM users");

        // EXAMPLE 1 - INSERT INTO BOOKINGS
        QueryExecutor.runQuery(
                "INSERT INTO bookings (id,user_id,listing_id,time) VALUES (2,3,400,'2025-10-15 17:20:26')"
        );
        QueryExecutor.runQuery("SELECT * FROM bookings");

        // EXAMPLE 3 — DELETE
//        QueryExecutor.runQuery("DELETE FROM users WHERE id = 50");

        QueryExecutor.runQuery(
                "INSERT INTO listings (id,title,approved,units) VALUES (4,'Bangalore to Goa Flight',3,2)"
        );
        QueryExecutor.runQuery("SELECT * FROM listings");

        // Now everything also appears in MySQL Workbench instantly
    }
}
