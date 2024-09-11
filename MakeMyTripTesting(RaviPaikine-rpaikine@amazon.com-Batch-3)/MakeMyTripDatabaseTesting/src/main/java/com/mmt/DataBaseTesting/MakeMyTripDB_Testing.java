package com.mmt.DataBaseTesting;

import javax.xml.transform.Result;
import java.sql.*;

public class MakeMyTripDB_Testing {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/makemytripdbtesting";


        String USER = "root";
        String PASS = "Guts@8446";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Create tables
            String createOrderTable = "CREATE TABLE IF NOT EXISTS OrderTable (order_id INT AUTO_INCREMENT, product_name VARCHAR(255), price DECIMAL(10, 2), PRIMARY KEY (order_id))";
            stmt.executeUpdate(createOrderTable);

            String createCustomerTable = "CREATE TABLE IF NOT EXISTS CustomerTable (customer_id INT AUTO_INCREMENT, customer_name VARCHAR(255), region VARCHAR(255), PRIMARY KEY (customer_id))";
            stmt.executeUpdate(createCustomerTable);

            String createSalesTable = "CREATE TABLE IF NOT EXISTS SalesTable (sale_id INT AUTO_INCREMENT, order_id INT, customer_id INT, region VARCHAR(255), ticket_rate DECIMAL(10, 2), PRIMARY KEY (sale_id), FOREIGN KEY (order_id) REFERENCES OrderTable(order_id), FOREIGN KEY (customer_id) REFERENCES CustomerTable(customer_id))";
            stmt.executeUpdate(createSalesTable);

            // Insert Data - you can use loops to add 50 entries
            String insertOrderData = "INSERT INTO OrderTable (product_name, price) VALUES ('Chair', 50), ('Table', 180), ('Lamp', 112), ('Vase', 90), ('Chair', 60)";
            stmt.executeUpdate(insertOrderData);

            String insertCustomerData = "INSERT INTO CustomerTable (customer_name, region) VALUES ('john Doe', 'Australia'), ('James Bond', 'UK'), ('Ethan Hunt', 'USA'), ('Hugh Jackman', 'Australia'), ('Virat Kohli', 'India')";
            stmt.executeUpdate(insertCustomerData);

            String insertSalesData = "INSERT INTO SalesTable (order_id, customer_id, region, ticket_rate) VALUES (1, 1, 'Australia', 60), (2, 2, 'UK', 90), (3, 3, 'USA', 130), (4, 4, 'Australia', 55                                                                                              ), (5, 5, 'India', 80)";
            stmt.executeUpdate(insertSalesData);


            // Find duplicate records
            String findDuplicates = "SELECT product_name, COUNT(*) AS count FROM OrderTable GROUP BY product_name HAVING count > 1";
            ResultSet duplicatesResult = stmt.executeQuery(findDuplicates);
            while (duplicatesResult.next()) {
                System.out.println("Duplicate product: " + duplicatesResult.getString("product_name"));
            }

            // Product with max price
            String maxPriceProduct = "SELECT product_name FROM OrderTable WHERE price = (SELECT MAX(price) FROM OrderTable)";
            ResultSet maxPriceResult = stmt.executeQuery(maxPriceProduct);
            while (maxPriceResult.next()) {
                System.out.println("Product with max price: " + maxPriceResult.getString("product_name"));
            }

            // Region with maximum ticket rate
            String maxTicketRateRegion = "SELECT region FROM SalesTable WHERE ticket_rate = (SELECT MAX(ticket_rate) FROM SalesTable)";
            ResultSet maxTicketRateResult = stmt.executeQuery(maxTicketRateRegion);
            while (maxTicketRateResult.next()) {
                System.out.println("Region with max ticket rate: " + maxTicketRateResult.getString("region"));
            }

            // Region-wise most traveled customer
            String mostTraveledCustomer = "SELECT c.region, c.customer_name, COUNT(*) AS travels " +
                    "FROM SalesTable s " +
                    "JOIN CustomerTable c ON s.customer_id = c.customer_id " +
                    "GROUP BY c.region, c.customer_id " +
                    "ORDER BY travels DESC";
            ResultSet mostTraveledResult = stmt.executeQuery(mostTraveledCustomer);
            while (mostTraveledResult.next()) {
                System.out.println("Region: " + mostTraveledResult.getString("region") + " - Most traveled customer: " + mostTraveledResult.getString("customer_name"));
            }


            duplicatesResult.close();
            maxPriceResult.close();
            maxTicketRateResult.close();
            mostTraveledResult.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}







