package com.session.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TableManager implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TableManager.class);

    @Override
    public void run(String... args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/spring", "root", ""); 
            Statement stmt = conn.createStatement();

            // users table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (\n" +
            "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    username VARCHAR(50) NOT NULL,\n" +
            "    password VARCHAR(255) NOT NULL,\n" +
            "    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
            "    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n" +
            ")");

            // produt table
            stmt.execute("CREATE TABLE IF NOT EXISTS products (\n" +
            "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    product_name VARCHAR(50) NOT NULL,\n" +
            "    product_description VARCHAR(255) NOT NULL,\n" +
            "    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
            "    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n" +
            ")");

            logger.info("Tables created or already exist");

        } catch (SQLException e) {
            // TODO: handle exception
            logger.error("Error creating tables", e);
        }
    }
}
