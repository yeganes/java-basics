package com.library.dBConnection;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class DBConnection {

        private static HikariDataSource dataSource;

        static {
            HikariConfig config = new HikariConfig();

            config.setJdbcUrl("jdbc:mysql://localhost:3306/library");
            config.setUsername("root");
            config.setPassword("Ysa291182");

            config.setMaximumPoolSize(10);
            config.setPoolName("LibraryPool");
            config.setConnectionTimeout(30000);
            config.setLeakDetectionThreshold(2000);

            dataSource = new HikariDataSource(config);
        }

        public Connection connect() throws SQLException {
            return dataSource.getConnection();
        }
    }

