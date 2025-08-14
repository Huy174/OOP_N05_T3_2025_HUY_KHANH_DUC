package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AivenConnection {

    // URL kết nối tới container MySQL mới
    private static final String URL = "jdbc:mysql://mysql-2ec51b7c-abccccc.c.aivencloud.com:12951/OOP_N05_T3?useSSL=true&serverTimezone=UTC";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_CgE0dOLOdYPd9HqJUQR";


    // Lấy Connection
    public static Connection getConnection() {
        try {
            // Load driver (JDBC 4+ tự động load, nhưng để rõ ràng)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công!");
            return conn;

        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy MySQL JDBC Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại!");
            e.printStackTrace();
        }
        return null;
    }

    // Đóng Connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                    System.out.println("Đóng kết nối thành công.");
                }
            } catch (SQLException e) {
                System.err.println("Đóng kết nối thất bại!");
                e.printStackTrace();
            }
        }
    }
}
