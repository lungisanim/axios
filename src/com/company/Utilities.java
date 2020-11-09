package com.company;

public class Utilities {
    public static void sanitizeInput(int input){
        if (input > 1 || input < 0)
            System.exit(1);
    }
}
