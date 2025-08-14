package com.example.servingwebcontent.database;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = AivenConnection.getConnection();
        AivenConnection.closeConnection(conn);
    }
}
