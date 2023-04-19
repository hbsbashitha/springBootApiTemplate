package com.bhashitha.springBootApiTemplate.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashingUtils {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }
}
