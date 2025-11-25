package dao;

import java.sql.*;

public class QueryExecutor {

    public static void runQuery(String sql) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            boolean isResultSet = stmt.execute(sql);

            if (isResultSet) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData meta = rs.getMetaData();
                int colCount = meta.getColumnCount();

                // Print result table
                while (rs.next()) {
                    for (int i = 1; i <= colCount; i++) {
                        System.out.print(meta.getColumnName(i) + "=" + rs.getString(i) + "  ");
                    }
                    System.out.println();
                }
            } else {
                int updated = stmt.getUpdateCount();
                System.out.println("Query OK, rows affected: " + updated);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}

