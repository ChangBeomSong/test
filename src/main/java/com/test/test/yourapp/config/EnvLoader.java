package com.test.test.yourapp.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    public static void load() {
        System.out.println("=== EnvLoader.load() START ===");
        System.out.println("user.dir=" + System.getProperty("user.dir"));
        System.out.println("catalina.base=" + System.getProperty("catalina.base"));

        Dotenv dotenv = Dotenv.configure()
                .directory(System.getProperty("catalina.base")) // ★ 여기 고정
                .ignoreIfMissing()
                .load();

        set("DB_DRIVER", dotenv.get("DB_DRIVER"));
        set("DB_URL", dotenv.get("DB_URL"));
        set("DB_USERNAME", dotenv.get("DB_USERNAME"));
        set("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        System.out.println("dotenv DB_DRIVER=" + dotenv.get("DB_DRIVER"));
        System.out.println("sys DB_DRIVER=" + System.getProperty("DB_DRIVER"));
        System.out.println("=== EnvLoader.load() END ===");
    }

    private static void set(String key, String value) {
        if (value != null && !value.isBlank()) {
            System.setProperty(key, value);
        }
    }
}